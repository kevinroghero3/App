package com.google.common.graph;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes5.dex */
@DoNotMock("Use NetworkBuilder to create a real instance")
@ElementTypesAreNonnullByDefault
public interface Network<N, E> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    Set<E> adjacentEdges(E e);

    Set<N> adjacentNodes(N n2);

    boolean allowsParallelEdges();

    boolean allowsSelfLoops();

    Graph<N> asGraph();

    int degree(N n2);

    @CheckForNull
    E edgeConnectingOrNull(EndpointPair<N> endpointPair);

    @CheckForNull
    E edgeConnectingOrNull(N n2, N n3);

    ElementOrder<E> edgeOrder();

    Set<E> edges();

    Set<E> edgesConnecting(EndpointPair<N> endpointPair);

    Set<E> edgesConnecting(N n2, N n3);

    boolean equals(@CheckForNull Object obj);

    boolean hasEdgeConnecting(EndpointPair<N> endpointPair);

    boolean hasEdgeConnecting(N n2, N n3);

    int hashCode();

    int inDegree(N n2);

    Set<E> inEdges(N n2);

    Set<E> incidentEdges(N n2);

    EndpointPair<N> incidentNodes(E e);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N n2);

    Set<E> outEdges(N n2);

    @Override // com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    Set<N> predecessors(N n2);

    @Override // com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    Set<N> successors(N n2);
}
