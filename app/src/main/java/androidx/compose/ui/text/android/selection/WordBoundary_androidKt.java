package androidx.compose.ui.text.android.selection;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class WordBoundary_androidKt {
    public static final int getWordStart(@NotNull WordIterator wordIterator, int i) {
        int prevWordBeginningOnTwoWordsBoundary;
        if (wordIterator.isOnPunctuation(wordIterator.prevBoundary(i))) {
            prevWordBeginningOnTwoWordsBoundary = wordIterator.getPunctuationBeginning(i);
        } else {
            prevWordBeginningOnTwoWordsBoundary = wordIterator.getPrevWordBeginningOnTwoWordsBoundary(i);
        }
        return prevWordBeginningOnTwoWordsBoundary == -1 ? i : prevWordBeginningOnTwoWordsBoundary;
    }

    public static final int getWordEnd(@NotNull WordIterator wordIterator, int i) {
        int nextWordEndOnTwoWordBoundary;
        if (wordIterator.isAfterPunctuation(wordIterator.nextBoundary(i))) {
            nextWordEndOnTwoWordBoundary = wordIterator.getPunctuationEnd(i);
        } else {
            nextWordEndOnTwoWordBoundary = wordIterator.getNextWordEndOnTwoWordBoundary(i);
        }
        return nextWordEndOnTwoWordBoundary == -1 ? i : nextWordEndOnTwoWordBoundary;
    }
}
