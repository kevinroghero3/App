package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;

/* JADX INFO: loaded from: classes4.dex */
public final class EditingBufferKt {
    /* JADX INFO: renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m3296updateRangeAfterDeletepWDy79M(long j, long j2) {
        int iM3131getLengthimpl;
        int iM3133getMinimpl = TextRange.m3133getMinimpl(j);
        int iM3132getMaximpl = TextRange.m3132getMaximpl(j);
        if (TextRange.m3137intersects5zctL8(j2, j)) {
            if (TextRange.m3125contains5zctL8(j2, j)) {
                iM3133getMinimpl = TextRange.m3133getMinimpl(j2);
                iM3132getMaximpl = iM3133getMinimpl;
            } else {
                if (TextRange.m3125contains5zctL8(j, j2)) {
                    iM3131getLengthimpl = TextRange.m3131getLengthimpl(j2);
                } else if (TextRange.m3126containsimpl(j2, iM3133getMinimpl)) {
                    iM3133getMinimpl = TextRange.m3133getMinimpl(j2);
                    iM3131getLengthimpl = TextRange.m3131getLengthimpl(j2);
                } else {
                    iM3132getMaximpl = TextRange.m3133getMinimpl(j2);
                }
                iM3132getMaximpl -= iM3131getLengthimpl;
            }
        } else if (iM3132getMaximpl > TextRange.m3133getMinimpl(j2)) {
            iM3133getMinimpl -= TextRange.m3131getLengthimpl(j2);
            iM3131getLengthimpl = TextRange.m3131getLengthimpl(j2);
            iM3132getMaximpl -= iM3131getLengthimpl;
        }
        return TextRangeKt.TextRange(iM3133getMinimpl, iM3132getMaximpl);
    }
}
