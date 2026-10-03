package okhttp3.internal.connection;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.Address;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ExchangeFinder {
    private final Address address;
    private final RealCall call;
    private RealConnection connectingConnection;
    private final RealConnectionPool connectionPool;
    private int connectionShutdownCount;
    private final EventListener eventListener;
    private Route nextRouteToTry;
    private int otherFailureCount;
    private int refusedStreamCount;
    private RouteSelector.Selection routeSelection;
    private RouteSelector routeSelector;

    public ExchangeFinder(@NotNull RealConnectionPool connectionPool, @NotNull Address address, @NotNull RealCall call, @NotNull EventListener eventListener) {
        Intrinsics.checkParameterIsNotNull(connectionPool, "connectionPool");
        Intrinsics.checkParameterIsNotNull(address, "address");
        Intrinsics.checkParameterIsNotNull(call, "call");
        Intrinsics.checkParameterIsNotNull(eventListener, "eventListener");
        this.connectionPool = connectionPool;
        this.address = address;
        this.call = call;
        this.eventListener = eventListener;
    }

    public final Address getAddress$okhttp() {
        return this.address;
    }

    public final ExchangeCodec find(@NotNull OkHttpClient client, @NotNull RealInterceptorChain chain) {
        Intrinsics.checkParameterIsNotNull(client, "client");
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        try {
            return findHealthyConnection(chain.getConnectTimeoutMillis$okhttp(), chain.getReadTimeoutMillis$okhttp(), chain.getWriteTimeoutMillis$okhttp(), client.pingIntervalMillis(), client.retryOnConnectionFailure(), !Intrinsics.areEqual(chain.getRequest$okhttp().method(), "GET")).newCodec$okhttp(client, chain);
        } catch (IOException e) {
            trackFailure(e);
            throw new RouteException(e);
        } catch (RouteException e2) {
            trackFailure(e2.getLastConnectException());
            throw e2;
        }
    }

    private final RealConnection findHealthyConnection(int i, int i2, int i3, int i4, boolean z, boolean z2) throws Throwable {
        while (true) {
            RealConnection realConnectionFindConnection = findConnection(i, i2, i3, i4, z);
            if (realConnectionFindConnection.isHealthy(z2)) {
                return realConnectionFindConnection;
            }
            realConnectionFindConnection.noNewExchanges();
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0052  */
    /* JADX WARN: Code duplicated, block: B:32:0x008b  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ec  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [T, okhttp3.internal.connection.RealConnection] */
    private final RealConnection findConnection(int i, int i2, int i3, int i4, boolean z) throws Throwable {
        Socket socket;
        Socket socketReleaseConnectionNoEvents$okhttp;
        RealConnection connection;
        Route next;
        boolean z2;
        boolean z3;
        List<Route> routes;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this.connectionPool) {
            if (this.call.isCanceled()) {
                throw new IOException("Canceled");
            }
            objectRef.element = this.call.getConnection();
            socket = null;
            if (this.call.getConnection() == null) {
                socketReleaseConnectionNoEvents$okhttp = null;
            } else {
                RealConnection connection2 = this.call.getConnection();
                if (connection2 == null) {
                    Intrinsics.throwNpe();
                }
                if (!connection2.getNoNewExchanges()) {
                    RealConnection connection3 = this.call.getConnection();
                    if (connection3 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (connection3.supportsUrl(this.address.url())) {
                        socketReleaseConnectionNoEvents$okhttp = null;
                    }
                }
                socketReleaseConnectionNoEvents$okhttp = this.call.releaseConnectionNoEvents$okhttp();
            }
            if (this.call.getConnection() != null) {
                connection = this.call.getConnection();
                objectRef.element = null;
            } else {
                connection = null;
            }
            if (connection == null) {
                this.refusedStreamCount = 0;
                this.connectionShutdownCount = 0;
                this.otherFailureCount = 0;
                if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, null, false)) {
                    connection = this.call.getConnection();
                    next = null;
                    z2 = true;
                } else {
                    next = this.nextRouteToTry;
                    if (next != null) {
                        this.nextRouteToTry = null;
                    } else {
                        next = null;
                    }
                    z2 = false;
                }
            } else {
                next = null;
                z2 = false;
            }
            Unit unit = Unit.INSTANCE;
        }
        if (socketReleaseConnectionNoEvents$okhttp != null) {
            Util.closeQuietly(socketReleaseConnectionNoEvents$okhttp);
        }
        RealConnection realConnection = (RealConnection) objectRef.element;
        if (realConnection != null) {
            EventListener eventListener = this.eventListener;
            RealCall realCall = this.call;
            if (realConnection == null) {
                Intrinsics.throwNpe();
            }
            eventListener.connectionReleased(realCall, realConnection);
        }
        if (z2) {
            EventListener eventListener2 = this.eventListener;
            RealCall realCall2 = this.call;
            if (connection == null) {
                Intrinsics.throwNpe();
            }
            eventListener2.connectionAcquired(realCall2, connection);
        }
        if (connection != null) {
            return connection;
        }
        if (next != null) {
            z3 = false;
        } else {
            RouteSelector.Selection selection = this.routeSelection;
            if (selection != null) {
                if (selection == null) {
                    Intrinsics.throwNpe();
                }
                if (selection.hasNext()) {
                    z3 = false;
                }
            }
            RouteSelector routeSelector = this.routeSelector;
            if (routeSelector == null) {
                routeSelector = new RouteSelector(this.address, this.call.getClient().getRouteDatabase(), this.call, this.eventListener);
                this.routeSelector = routeSelector;
            }
            this.routeSelection = routeSelector.next();
            z3 = true;
        }
        synchronized (this.connectionPool) {
            if (this.call.isCanceled()) {
                throw new IOException("Canceled");
            }
            if (z3) {
                RouteSelector.Selection selection2 = this.routeSelection;
                if (selection2 == null) {
                    Intrinsics.throwNpe();
                }
                routes = selection2.getRoutes();
                if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, routes, false)) {
                    connection = this.call.getConnection();
                    z2 = true;
                }
            } else {
                routes = null;
            }
            if (!z2) {
                if (next == null) {
                    RouteSelector.Selection selection3 = this.routeSelection;
                    if (selection3 == null) {
                        Intrinsics.throwNpe();
                    }
                    next = selection3.next();
                }
                RealConnectionPool realConnectionPool = this.connectionPool;
                if (next == null) {
                    Intrinsics.throwNpe();
                }
                connection = new RealConnection(realConnectionPool, next);
                this.connectingConnection = connection;
            }
        }
        if (z2) {
            EventListener eventListener3 = this.eventListener;
            RealCall realCall3 = this.call;
            if (connection == null) {
                Intrinsics.throwNpe();
            }
            eventListener3.connectionAcquired(realCall3, connection);
            if (connection == null) {
                Intrinsics.throwNpe();
            }
            return connection;
        }
        if (connection == null) {
            Intrinsics.throwNpe();
        }
        connection.connect(i, i2, i3, i4, z, this.call, this.eventListener);
        this.call.getClient().getRouteDatabase().connected(connection.route());
        synchronized (this.connectionPool) {
            this.connectingConnection = null;
            if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, routes, true)) {
                connection.setNoNewExchanges(true);
                socket = connection.socket();
                connection = this.call.getConnection();
                this.nextRouteToTry = next;
            } else {
                this.connectionPool.put(connection);
                this.call.acquireConnectionNoEvents(connection);
            }
        }
        if (socket != null) {
            Util.closeQuietly(socket);
        }
        EventListener eventListener4 = this.eventListener;
        RealCall realCall4 = this.call;
        if (connection == null) {
            Intrinsics.throwNpe();
        }
        eventListener4.connectionAcquired(realCall4, connection);
        if (connection == null) {
            Intrinsics.throwNpe();
        }
        return connection;
    }

    public final RealConnection connectingConnection() {
        RealConnectionPool realConnectionPool = this.connectionPool;
        if (!Util.assertionsEnabled || Thread.holdsLock(realConnectionPool)) {
            return this.connectingConnection;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(threadCurrentThread, "Thread.currentThread()");
        sb.append(threadCurrentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(realConnectionPool);
        throw new AssertionError(sb.toString());
    }

    public final void trackFailure(@NotNull IOException e) {
        Intrinsics.checkParameterIsNotNull(e, "e");
        RealConnectionPool realConnectionPool = this.connectionPool;
        if (!Util.assertionsEnabled || !Thread.holdsLock(realConnectionPool)) {
            synchronized (this.connectionPool) {
                this.nextRouteToTry = null;
                if ((e instanceof StreamResetException) && ((StreamResetException) e).errorCode == ErrorCode.REFUSED_STREAM) {
                    this.refusedStreamCount++;
                } else if (e instanceof ConnectionShutdownException) {
                    this.connectionShutdownCount++;
                } else {
                    this.otherFailureCount++;
                }
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(threadCurrentThread, "Thread.currentThread()");
        sb.append(threadCurrentThread.getName());
        sb.append(" MUST NOT hold lock on ");
        sb.append(realConnectionPool);
        throw new AssertionError(sb.toString());
    }

    public final boolean retryAfterFailure() {
        synchronized (this.connectionPool) {
            if (this.refusedStreamCount == 0 && this.connectionShutdownCount == 0 && this.otherFailureCount == 0) {
                return false;
            }
            if (this.nextRouteToTry != null) {
                return true;
            }
            if (retryCurrentRoute()) {
                RealConnection connection = this.call.getConnection();
                if (connection == null) {
                    Intrinsics.throwNpe();
                }
                this.nextRouteToTry = connection.route();
                return true;
            }
            RouteSelector.Selection selection = this.routeSelection;
            if (selection != null && selection.hasNext()) {
                return true;
            }
            RouteSelector routeSelector = this.routeSelector;
            if (routeSelector == null) {
                return true;
            }
            return routeSelector.hasNext();
        }
    }

    private final boolean retryCurrentRoute() {
        RealConnection connection;
        return this.refusedStreamCount <= 1 && this.connectionShutdownCount <= 1 && this.otherFailureCount <= 0 && (connection = this.call.getConnection()) != null && connection.getRouteFailureCount$okhttp() == 0 && Util.canReuseConnectionFor(connection.route().address().url(), this.address.url());
    }
}
