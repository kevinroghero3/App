package org.greenrobot.eventbus;

/* JADX INFO: loaded from: classes3.dex */
final class PendingPostQueue {
    private PendingPost head;
    private PendingPost tail;

    PendingPostQueue() {
    }

    void enqueue(PendingPost pendingPost) {
        synchronized (this) {
            try {
                if (pendingPost == null) {
                    throw new NullPointerException("null cannot be enqueued");
                }
                PendingPost pendingPost2 = this.tail;
                if (pendingPost2 != null) {
                    pendingPost2.next = pendingPost;
                    this.tail = pendingPost;
                } else if (this.head == null) {
                    this.tail = pendingPost;
                    this.head = pendingPost;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    PendingPost poll() {
        PendingPost pendingPost;
        synchronized (this) {
            pendingPost = this.head;
            if (pendingPost != null) {
                PendingPost pendingPost2 = pendingPost.next;
                this.head = pendingPost2;
                if (pendingPost2 == null) {
                    this.tail = null;
                }
            }
        }
        return pendingPost;
    }

    PendingPost poll(int i) throws InterruptedException {
        PendingPost pendingPostPoll;
        synchronized (this) {
            if (this.head == null) {
                wait(i);
            }
            pendingPostPoll = poll();
        }
        return pendingPostPoll;
    }
}
