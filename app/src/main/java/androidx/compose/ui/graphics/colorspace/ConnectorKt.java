package androidx.compose.ui.graphics.colorspace;

import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class ConnectorKt {
    private static final MutableIntObjectMap<Connector> Connectors;

    /* JADX INFO: renamed from: connectorKey-YBCOT_4, reason: not valid java name */
    public static final int m1597connectorKeyYBCOT_4(int i, int i2, int i3) {
        return i | (i2 << 6) | (i3 << 12);
    }

    public static final MutableIntObjectMap<Connector> getConnectors() {
        return Connectors;
    }

    static {
        ColorSpaces colorSpaces = ColorSpaces.INSTANCE;
        int id$ui_graphics_release = colorSpaces.getSrgb().getId$ui_graphics_release();
        int id$ui_graphics_release2 = colorSpaces.getSrgb().getId$ui_graphics_release();
        RenderIntent.Companion companion = RenderIntent.Companion;
        int iM1606getPerceptualuksYyKA = companion.m1606getPerceptualuksYyKA();
        Connector connectorIdentity$ui_graphics_release = Connector.Companion.identity$ui_graphics_release(colorSpaces.getSrgb());
        int id$ui_graphics_release3 = colorSpaces.getSrgb().getId$ui_graphics_release();
        int id$ui_graphics_release4 = colorSpaces.getOklab().getId$ui_graphics_release();
        int iM1606getPerceptualuksYyKA2 = companion.m1606getPerceptualuksYyKA();
        DefaultConstructorMarker defaultConstructorMarker = null;
        Connector connector = new Connector(colorSpaces.getSrgb(), colorSpaces.getOklab(), companion.m1606getPerceptualuksYyKA(), defaultConstructorMarker);
        int id$ui_graphics_release5 = colorSpaces.getOklab().getId$ui_graphics_release();
        int id$ui_graphics_release6 = colorSpaces.getSrgb().getId$ui_graphics_release();
        int iM1606getPerceptualuksYyKA3 = companion.m1606getPerceptualuksYyKA();
        Connectors = IntObjectMapKt.mutableIntObjectMapOf((id$ui_graphics_release2 << 6) | id$ui_graphics_release | (iM1606getPerceptualuksYyKA << 12), connectorIdentity$ui_graphics_release, (id$ui_graphics_release4 << 6) | id$ui_graphics_release3 | (iM1606getPerceptualuksYyKA2 << 12), connector, (id$ui_graphics_release6 << 6) | id$ui_graphics_release5 | (iM1606getPerceptualuksYyKA3 << 12), new Connector(colorSpaces.getOklab(), colorSpaces.getSrgb(), companion.m1606getPerceptualuksYyKA(), defaultConstructorMarker));
    }
}
