package androidx.compose.ui.input.key;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.ItemTouchHelper;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.facebook.imageutils.TiffUtil;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.mlkit.common.MlKitException;
import com.salesforce.marketingcloud.analytics.stats.b;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes.dex */
@JvmInline
public final class Key {
    private final long keyCode;
    public static final Companion Companion = new Companion(null);
    private static final long Unknown = Key_androidKt.Key(0);
    private static final long SoftLeft = Key_androidKt.Key(1);
    private static final long SoftRight = Key_androidKt.Key(2);
    private static final long Home = Key_androidKt.Key(3);
    private static final long Back = Key_androidKt.Key(4);
    private static final long Help = Key_androidKt.Key(259);
    private static final long NavigatePrevious = Key_androidKt.Key(260);
    private static final long NavigateNext = Key_androidKt.Key(261);
    private static final long NavigateIn = Key_androidKt.Key(262);
    private static final long NavigateOut = Key_androidKt.Key(263);
    private static final long SystemNavigationUp = Key_androidKt.Key(280);
    private static final long SystemNavigationDown = Key_androidKt.Key(281);
    private static final long SystemNavigationLeft = Key_androidKt.Key(282);
    private static final long SystemNavigationRight = Key_androidKt.Key(283);
    private static final long Call = Key_androidKt.Key(5);
    private static final long EndCall = Key_androidKt.Key(6);
    private static final long DirectionUp = Key_androidKt.Key(19);
    private static final long DirectionDown = Key_androidKt.Key(20);
    private static final long DirectionLeft = Key_androidKt.Key(21);
    private static final long DirectionRight = Key_androidKt.Key(22);
    private static final long DirectionCenter = Key_androidKt.Key(23);
    private static final long DirectionUpLeft = Key_androidKt.Key(268);
    private static final long DirectionDownLeft = Key_androidKt.Key(269);
    private static final long DirectionUpRight = Key_androidKt.Key(RotationOptions.ROTATE_270);
    private static final long DirectionDownRight = Key_androidKt.Key(271);
    private static final long VolumeUp = Key_androidKt.Key(24);
    private static final long VolumeDown = Key_androidKt.Key(25);
    private static final long Power = Key_androidKt.Key(26);
    private static final long Camera = Key_androidKt.Key(27);
    private static final long Clear = Key_androidKt.Key(28);
    private static final long Zero = Key_androidKt.Key(7);
    private static final long One = Key_androidKt.Key(8);
    private static final long Two = Key_androidKt.Key(9);
    private static final long Three = Key_androidKt.Key(10);
    private static final long Four = Key_androidKt.Key(11);
    private static final long Five = Key_androidKt.Key(12);
    private static final long Six = Key_androidKt.Key(13);
    private static final long Seven = Key_androidKt.Key(14);
    private static final long Eight = Key_androidKt.Key(15);
    private static final long Nine = Key_androidKt.Key(16);
    private static final long Plus = Key_androidKt.Key(81);
    private static final long Minus = Key_androidKt.Key(69);
    private static final long Multiply = Key_androidKt.Key(17);
    private static final long Equals = Key_androidKt.Key(70);
    private static final long Pound = Key_androidKt.Key(18);
    private static final long A = Key_androidKt.Key(29);
    private static final long B = Key_androidKt.Key(30);
    private static final long C = Key_androidKt.Key(31);
    private static final long D = Key_androidKt.Key(32);
    private static final long E = Key_androidKt.Key(33);
    private static final long F = Key_androidKt.Key(34);
    private static final long G = Key_androidKt.Key(35);
    private static final long H = Key_androidKt.Key(36);
    private static final long I = Key_androidKt.Key(37);
    private static final long J = Key_androidKt.Key(38);
    private static final long K = Key_androidKt.Key(39);
    private static final long L = Key_androidKt.Key(40);
    private static final long M = Key_androidKt.Key(41);
    private static final long N = Key_androidKt.Key(42);
    private static final long O = Key_androidKt.Key(43);
    private static final long P = Key_androidKt.Key(44);
    private static final long Q = Key_androidKt.Key(45);
    private static final long R = Key_androidKt.Key(46);
    private static final long S = Key_androidKt.Key(47);
    private static final long T = Key_androidKt.Key(48);
    private static final long U = Key_androidKt.Key(49);
    private static final long V = Key_androidKt.Key(50);
    private static final long W = Key_androidKt.Key(51);
    private static final long X = Key_androidKt.Key(52);
    private static final long Y = Key_androidKt.Key(53);
    private static final long Z = Key_androidKt.Key(54);
    private static final long Comma = Key_androidKt.Key(55);
    private static final long Period = Key_androidKt.Key(56);
    private static final long AltLeft = Key_androidKt.Key(57);
    private static final long AltRight = Key_androidKt.Key(58);
    private static final long ShiftLeft = Key_androidKt.Key(59);
    private static final long ShiftRight = Key_androidKt.Key(60);
    private static final long Tab = Key_androidKt.Key(61);
    private static final long Spacebar = Key_androidKt.Key(62);
    private static final long Symbol = Key_androidKt.Key(63);
    private static final long Browser = Key_androidKt.Key(64);
    private static final long Envelope = Key_androidKt.Key(65);
    private static final long Enter = Key_androidKt.Key(66);
    private static final long Backspace = Key_androidKt.Key(67);
    private static final long Delete = Key_androidKt.Key(112);
    private static final long Escape = Key_androidKt.Key(b.f40o);
    private static final long CtrlLeft = Key_androidKt.Key(113);
    private static final long CtrlRight = Key_androidKt.Key(114);
    private static final long CapsLock = Key_androidKt.Key(115);
    private static final long ScrollLock = Key_androidKt.Key(116);
    private static final long MetaLeft = Key_androidKt.Key(117);
    private static final long MetaRight = Key_androidKt.Key(118);
    private static final long Function = Key_androidKt.Key(119);
    private static final long PrintScreen = Key_androidKt.Key(SyslogConstants.LOG_CLOCK);
    private static final long Break = Key_androidKt.Key(121);
    private static final long MoveHome = Key_androidKt.Key(122);
    private static final long MoveEnd = Key_androidKt.Key(123);
    private static final long Insert = Key_androidKt.Key(124);
    private static final long Cut = Key_androidKt.Key(277);
    private static final long Copy = Key_androidKt.Key(278);
    private static final long Paste = Key_androidKt.Key(279);
    private static final long Grave = Key_androidKt.Key(68);
    private static final long LeftBracket = Key_androidKt.Key(71);
    private static final long RightBracket = Key_androidKt.Key(72);
    private static final long Slash = Key_androidKt.Key(76);
    private static final long Backslash = Key_androidKt.Key(73);
    private static final long Semicolon = Key_androidKt.Key(74);
    private static final long Apostrophe = Key_androidKt.Key(75);
    private static final long At = Key_androidKt.Key(77);
    private static final long Number = Key_androidKt.Key(78);
    private static final long HeadsetHook = Key_androidKt.Key(79);
    private static final long Focus = Key_androidKt.Key(80);
    private static final long Menu = Key_androidKt.Key(82);
    private static final long Notification = Key_androidKt.Key(83);
    private static final long Search = Key_androidKt.Key(84);
    private static final long PageUp = Key_androidKt.Key(92);
    private static final long PageDown = Key_androidKt.Key(93);
    private static final long PictureSymbols = Key_androidKt.Key(94);
    private static final long SwitchCharset = Key_androidKt.Key(95);
    private static final long ButtonA = Key_androidKt.Key(96);
    private static final long ButtonB = Key_androidKt.Key(97);
    private static final long ButtonC = Key_androidKt.Key(98);
    private static final long ButtonX = Key_androidKt.Key(99);
    private static final long ButtonY = Key_androidKt.Key(100);
    private static final long ButtonZ = Key_androidKt.Key(101);
    private static final long ButtonL1 = Key_androidKt.Key(102);
    private static final long ButtonR1 = Key_androidKt.Key(b.i);
    private static final long ButtonL2 = Key_androidKt.Key(104);
    private static final long ButtonR2 = Key_androidKt.Key(105);
    private static final long ButtonThumbLeft = Key_androidKt.Key(b.l);
    private static final long ButtonThumbRight = Key_androidKt.Key(107);
    private static final long ButtonStart = Key_androidKt.Key(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR);
    private static final long ButtonSelect = Key_androidKt.Key(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY);
    private static final long ButtonMode = Key_androidKt.Key(b.f39n);
    private static final long Button1 = Key_androidKt.Key(188);
    private static final long Button2 = Key_androidKt.Key(189);
    private static final long Button3 = Key_androidKt.Key(FacebookRequestErrorClassification.EC_INVALID_TOKEN);
    private static final long Button4 = Key_androidKt.Key(191);
    private static final long Button5 = Key_androidKt.Key(JfifUtil.MARKER_SOFn);
    private static final long Button6 = Key_androidKt.Key(193);
    private static final long Button7 = Key_androidKt.Key(194);
    private static final long Button8 = Key_androidKt.Key(195);
    private static final long Button9 = Key_androidKt.Key(196);
    private static final long Button10 = Key_androidKt.Key(197);
    private static final long Button11 = Key_androidKt.Key(198);
    private static final long Button12 = Key_androidKt.Key(199);
    private static final long Button13 = Key_androidKt.Key(200);
    private static final long Button14 = Key_androidKt.Key(201);
    private static final long Button15 = Key_androidKt.Key(202);
    private static final long Button16 = Key_androidKt.Key(203);
    private static final long Forward = Key_androidKt.Key(125);
    private static final long F1 = Key_androidKt.Key(131);
    private static final long F2 = Key_androidKt.Key(132);
    private static final long F3 = Key_androidKt.Key(133);
    private static final long F4 = Key_androidKt.Key(134);
    private static final long F5 = Key_androidKt.Key(135);
    private static final long F6 = Key_androidKt.Key(SyslogConstants.LOG_LOCAL1);
    private static final long F7 = Key_androidKt.Key(137);
    private static final long F8 = Key_androidKt.Key(138);
    private static final long F9 = Key_androidKt.Key(139);
    private static final long F10 = Key_androidKt.Key(140);
    private static final long F11 = Key_androidKt.Key(141);
    private static final long F12 = Key_androidKt.Key(142);
    private static final long NumLock = Key_androidKt.Key(143);
    private static final long NumPad0 = Key_androidKt.Key(SyslogConstants.LOG_LOCAL2);
    private static final long NumPad1 = Key_androidKt.Key(145);
    private static final long NumPad2 = Key_androidKt.Key(146);
    private static final long NumPad3 = Key_androidKt.Key(147);
    private static final long NumPad4 = Key_androidKt.Key(148);
    private static final long NumPad5 = Key_androidKt.Key(149);
    private static final long NumPad6 = Key_androidKt.Key(150);
    private static final long NumPad7 = Key_androidKt.Key(151);
    private static final long NumPad8 = Key_androidKt.Key(SyslogConstants.LOG_LOCAL3);
    private static final long NumPad9 = Key_androidKt.Key(153);
    private static final long NumPadDivide = Key_androidKt.Key(154);
    private static final long NumPadMultiply = Key_androidKt.Key(155);
    private static final long NumPadSubtract = Key_androidKt.Key(156);
    private static final long NumPadAdd = Key_androidKt.Key(157);
    private static final long NumPadDot = Key_androidKt.Key(158);
    private static final long NumPadComma = Key_androidKt.Key(159);
    private static final long NumPadEnter = Key_androidKt.Key(SyslogConstants.LOG_LOCAL4);
    private static final long NumPadEquals = Key_androidKt.Key(161);
    private static final long NumPadLeftParenthesis = Key_androidKt.Key(162);
    private static final long NumPadRightParenthesis = Key_androidKt.Key(163);
    private static final long MediaPlay = Key_androidKt.Key(WebSocketProtocol.PAYLOAD_SHORT);
    private static final long MediaPause = Key_androidKt.Key(127);
    private static final long MediaPlayPause = Key_androidKt.Key(85);
    private static final long MediaStop = Key_androidKt.Key(86);
    private static final long MediaRecord = Key_androidKt.Key(130);
    private static final long MediaNext = Key_androidKt.Key(87);
    private static final long MediaPrevious = Key_androidKt.Key(88);
    private static final long MediaRewind = Key_androidKt.Key(89);
    private static final long MediaFastForward = Key_androidKt.Key(90);
    private static final long MediaClose = Key_androidKt.Key(128);
    private static final long MediaAudioTrack = Key_androidKt.Key(222);
    private static final long MediaEject = Key_androidKt.Key(129);
    private static final long MediaTopMenu = Key_androidKt.Key(226);
    private static final long MediaSkipForward = Key_androidKt.Key(272);
    private static final long MediaSkipBackward = Key_androidKt.Key(273);
    private static final long MediaStepForward = Key_androidKt.Key(TiffUtil.TIFF_TAG_ORIENTATION);
    private static final long MediaStepBackward = Key_androidKt.Key(275);
    private static final long MicrophoneMute = Key_androidKt.Key(91);
    private static final long VolumeMute = Key_androidKt.Key(164);
    private static final long Info = Key_androidKt.Key(165);
    private static final long ChannelUp = Key_androidKt.Key(166);
    private static final long ChannelDown = Key_androidKt.Key(167);
    private static final long ZoomIn = Key_androidKt.Key(168);
    private static final long ZoomOut = Key_androidKt.Key(169);
    private static final long Tv = Key_androidKt.Key(170);
    private static final long Window = Key_androidKt.Key(171);
    private static final long Guide = Key_androidKt.Key(172);
    private static final long Dvr = Key_androidKt.Key(173);
    private static final long Bookmark = Key_androidKt.Key(174);
    private static final long Captions = Key_androidKt.Key(175);
    private static final long Settings = Key_androidKt.Key(SyslogConstants.LOG_LOCAL6);
    private static final long TvPower = Key_androidKt.Key(177);
    private static final long TvInput = Key_androidKt.Key(178);
    private static final long SetTopBoxPower = Key_androidKt.Key(179);
    private static final long SetTopBoxInput = Key_androidKt.Key(RotationOptions.ROTATE_180);
    private static final long AvReceiverPower = Key_androidKt.Key(181);
    private static final long AvReceiverInput = Key_androidKt.Key(182);
    private static final long ProgramRed = Key_androidKt.Key(183);
    private static final long ProgramGreen = Key_androidKt.Key(SyslogConstants.LOG_LOCAL7);
    private static final long ProgramYellow = Key_androidKt.Key(185);
    private static final long ProgramBlue = Key_androidKt.Key(186);
    private static final long AppSwitch = Key_androidKt.Key(187);
    private static final long LanguageSwitch = Key_androidKt.Key(204);
    private static final long MannerMode = Key_androidKt.Key(MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR);
    private static final long Toggle2D3D = Key_androidKt.Key(206);
    private static final long Contacts = Key_androidKt.Key(207);
    private static final long Calendar = Key_androidKt.Key(JfifUtil.MARKER_RST0);
    private static final long Music = Key_androidKt.Key(209);
    private static final long Calculator = Key_androidKt.Key(210);
    private static final long ZenkakuHankaru = Key_androidKt.Key(211);
    private static final long Eisu = Key_androidKt.Key(212);
    private static final long Muhenkan = Key_androidKt.Key(213);
    private static final long Henkan = Key_androidKt.Key(214);
    private static final long KatakanaHiragana = Key_androidKt.Key(JfifUtil.MARKER_RST7);
    private static final long Yen = Key_androidKt.Key(JfifUtil.MARKER_SOI);
    private static final long Ro = Key_androidKt.Key(JfifUtil.MARKER_EOI);
    private static final long Kana = Key_androidKt.Key(JfifUtil.MARKER_SOS);
    private static final long Assist = Key_androidKt.Key(219);
    private static final long BrightnessDown = Key_androidKt.Key(220);
    private static final long BrightnessUp = Key_androidKt.Key(221);
    private static final long Sleep = Key_androidKt.Key(223);
    private static final long WakeUp = Key_androidKt.Key(224);
    private static final long SoftSleep = Key_androidKt.Key(276);
    private static final long Pairing = Key_androidKt.Key(JfifUtil.MARKER_APP1);
    private static final long LastChannel = Key_androidKt.Key(229);
    private static final long TvDataService = Key_androidKt.Key(230);
    private static final long VoiceAssist = Key_androidKt.Key(231);
    private static final long TvRadioService = Key_androidKt.Key(232);
    private static final long TvTeletext = Key_androidKt.Key(233);
    private static final long TvNumberEntry = Key_androidKt.Key(234);
    private static final long TvTerrestrialAnalog = Key_androidKt.Key(235);
    private static final long TvTerrestrialDigital = Key_androidKt.Key(236);
    private static final long TvSatellite = Key_androidKt.Key(237);
    private static final long TvSatelliteBs = Key_androidKt.Key(238);
    private static final long TvSatelliteCs = Key_androidKt.Key(239);
    private static final long TvSatelliteService = Key_androidKt.Key(240);
    private static final long TvNetwork = Key_androidKt.Key(241);
    private static final long TvAntennaCable = Key_androidKt.Key(242);
    private static final long TvInputHdmi1 = Key_androidKt.Key(243);
    private static final long TvInputHdmi2 = Key_androidKt.Key(244);
    private static final long TvInputHdmi3 = Key_androidKt.Key(245);
    private static final long TvInputHdmi4 = Key_androidKt.Key(246);
    private static final long TvInputComposite1 = Key_androidKt.Key(247);
    private static final long TvInputComposite2 = Key_androidKt.Key(248);
    private static final long TvInputComponent1 = Key_androidKt.Key(249);
    private static final long TvInputComponent2 = Key_androidKt.Key(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
    private static final long TvInputVga1 = Key_androidKt.Key(251);
    private static final long TvAudioDescription = Key_androidKt.Key(252);
    private static final long TvAudioDescriptionMixingVolumeUp = Key_androidKt.Key(253);
    private static final long TvAudioDescriptionMixingVolumeDown = Key_androidKt.Key(254);
    private static final long TvZoomMode = Key_androidKt.Key(255);
    private static final long TvContentsMenu = Key_androidKt.Key(256);
    private static final long TvMediaContextMenu = Key_androidKt.Key(257);
    private static final long TvTimerProgramming = Key_androidKt.Key(258);
    private static final long StemPrimary = Key_androidKt.Key(264);
    private static final long Stem1 = Key_androidKt.Key(265);
    private static final long Stem2 = Key_androidKt.Key(266);
    private static final long Stem3 = Key_androidKt.Key(267);
    private static final long AllApps = Key_androidKt.Key(284);
    private static final long Refresh = Key_androidKt.Key(285);
    private static final long ThumbsUp = Key_androidKt.Key(286);
    private static final long ThumbsDown = Key_androidKt.Key(287);
    private static final long ProfileSwitch = Key_androidKt.Key(288);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Key m1925boximpl(long j) {
        return new Key(j);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1926constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1927equalsimpl(long j, Object obj) {
        return (obj instanceof Key) && j == ((Key) obj).m1931unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1928equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1929hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m1927equalsimpl(this.keyCode, obj);
    }

    public int hashCode() {
        return m1929hashCodeimpl(this.keyCode);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m1931unboximpl() {
        return this.keyCode;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getUnknown-EK5gGoQ, reason: not valid java name */
        public final long m2202getUnknownEK5gGoQ() {
            return Key.Unknown;
        }

        /* JADX INFO: renamed from: getSoftLeft-EK5gGoQ, reason: not valid java name */
        public final long m2149getSoftLeftEK5gGoQ() {
            return Key.SoftLeft;
        }

        /* JADX INFO: renamed from: getSoftRight-EK5gGoQ, reason: not valid java name */
        public final long m2150getSoftRightEK5gGoQ() {
            return Key.SoftRight;
        }

        /* JADX INFO: renamed from: getHome-EK5gGoQ, reason: not valid java name */
        public final long m2043getHomeEK5gGoQ() {
            return Key.Home;
        }

        /* JADX INFO: renamed from: getBack-EK5gGoQ, reason: not valid java name */
        public final long m1943getBackEK5gGoQ() {
            return Key.Back;
        }

        /* JADX INFO: renamed from: getHelp-EK5gGoQ, reason: not valid java name */
        public final long m2041getHelpEK5gGoQ() {
            return Key.Help;
        }

        /* JADX INFO: renamed from: getNavigatePrevious-EK5gGoQ, reason: not valid java name */
        public final long m2088getNavigatePreviousEK5gGoQ() {
            return Key.NavigatePrevious;
        }

        /* JADX INFO: renamed from: getNavigateNext-EK5gGoQ, reason: not valid java name */
        public final long m2086getNavigateNextEK5gGoQ() {
            return Key.NavigateNext;
        }

        /* JADX INFO: renamed from: getNavigateIn-EK5gGoQ, reason: not valid java name */
        public final long m2085getNavigateInEK5gGoQ() {
            return Key.NavigateIn;
        }

        /* JADX INFO: renamed from: getNavigateOut-EK5gGoQ, reason: not valid java name */
        public final long m2087getNavigateOutEK5gGoQ() {
            return Key.NavigateOut;
        }

        /* JADX INFO: renamed from: getSystemNavigationUp-EK5gGoQ, reason: not valid java name */
        public final long m2162getSystemNavigationUpEK5gGoQ() {
            return Key.SystemNavigationUp;
        }

        /* JADX INFO: renamed from: getSystemNavigationDown-EK5gGoQ, reason: not valid java name */
        public final long m2159getSystemNavigationDownEK5gGoQ() {
            return Key.SystemNavigationDown;
        }

        /* JADX INFO: renamed from: getSystemNavigationLeft-EK5gGoQ, reason: not valid java name */
        public final long m2160getSystemNavigationLeftEK5gGoQ() {
            return Key.SystemNavigationLeft;
        }

        /* JADX INFO: renamed from: getSystemNavigationRight-EK5gGoQ, reason: not valid java name */
        public final long m2161getSystemNavigationRightEK5gGoQ() {
            return Key.SystemNavigationRight;
        }

        /* JADX INFO: renamed from: getCall-EK5gGoQ, reason: not valid java name */
        public final long m1985getCallEK5gGoQ() {
            return Key.Call;
        }

        /* JADX INFO: renamed from: getEndCall-EK5gGoQ, reason: not valid java name */
        public final long m2013getEndCallEK5gGoQ() {
            return Key.EndCall;
        }

        /* JADX INFO: renamed from: getDirectionUp-EK5gGoQ, reason: not valid java name */
        public final long m2006getDirectionUpEK5gGoQ() {
            return Key.DirectionUp;
        }

        /* JADX INFO: renamed from: getDirectionDown-EK5gGoQ, reason: not valid java name */
        public final long m2001getDirectionDownEK5gGoQ() {
            return Key.DirectionDown;
        }

        /* JADX INFO: renamed from: getDirectionLeft-EK5gGoQ, reason: not valid java name */
        public final long m2004getDirectionLeftEK5gGoQ() {
            return Key.DirectionLeft;
        }

        /* JADX INFO: renamed from: getDirectionRight-EK5gGoQ, reason: not valid java name */
        public final long m2005getDirectionRightEK5gGoQ() {
            return Key.DirectionRight;
        }

        /* JADX INFO: renamed from: getDirectionCenter-EK5gGoQ, reason: not valid java name */
        public final long m2000getDirectionCenterEK5gGoQ() {
            return Key.DirectionCenter;
        }

        /* JADX INFO: renamed from: getDirectionUpLeft-EK5gGoQ, reason: not valid java name */
        public final long m2007getDirectionUpLeftEK5gGoQ() {
            return Key.DirectionUpLeft;
        }

        /* JADX INFO: renamed from: getDirectionDownLeft-EK5gGoQ, reason: not valid java name */
        public final long m2002getDirectionDownLeftEK5gGoQ() {
            return Key.DirectionDownLeft;
        }

        /* JADX INFO: renamed from: getDirectionUpRight-EK5gGoQ, reason: not valid java name */
        public final long m2008getDirectionUpRightEK5gGoQ() {
            return Key.DirectionUpRight;
        }

        /* JADX INFO: renamed from: getDirectionDownRight-EK5gGoQ, reason: not valid java name */
        public final long m2003getDirectionDownRightEK5gGoQ() {
            return Key.DirectionDownRight;
        }

        /* JADX INFO: renamed from: getVolumeUp-EK5gGoQ, reason: not valid java name */
        public final long m2207getVolumeUpEK5gGoQ() {
            return Key.VolumeUp;
        }

        /* JADX INFO: renamed from: getVolumeDown-EK5gGoQ, reason: not valid java name */
        public final long m2205getVolumeDownEK5gGoQ() {
            return Key.VolumeDown;
        }

        /* JADX INFO: renamed from: getPower-EK5gGoQ, reason: not valid java name */
        public final long m2124getPowerEK5gGoQ() {
            return Key.Power;
        }

        /* JADX INFO: renamed from: getCamera-EK5gGoQ, reason: not valid java name */
        public final long m1986getCameraEK5gGoQ() {
            return Key.Camera;
        }

        /* JADX INFO: renamed from: getClear-EK5gGoQ, reason: not valid java name */
        public final long m1991getClearEK5gGoQ() {
            return Key.Clear;
        }

        /* JADX INFO: renamed from: getZero-EK5gGoQ, reason: not valid java name */
        public final long m2216getZeroEK5gGoQ() {
            return Key.Zero;
        }

        /* JADX INFO: renamed from: getOne-EK5gGoQ, reason: not valid java name */
        public final long m2114getOneEK5gGoQ() {
            return Key.One;
        }

        /* JADX INFO: renamed from: getTwo-EK5gGoQ, reason: not valid java name */
        public final long m2200getTwoEK5gGoQ() {
            return Key.Two;
        }

        /* JADX INFO: renamed from: getThree-EK5gGoQ, reason: not valid java name */
        public final long m2165getThreeEK5gGoQ() {
            return Key.Three;
        }

        /* JADX INFO: renamed from: getFour-EK5gGoQ, reason: not valid java name */
        public final long m2034getFourEK5gGoQ() {
            return Key.Four;
        }

        /* JADX INFO: renamed from: getFive-EK5gGoQ, reason: not valid java name */
        public final long m2031getFiveEK5gGoQ() {
            return Key.Five;
        }

        /* JADX INFO: renamed from: getSix-EK5gGoQ, reason: not valid java name */
        public final long m2146getSixEK5gGoQ() {
            return Key.Six;
        }

        /* JADX INFO: renamed from: getSeven-EK5gGoQ, reason: not valid java name */
        public final long m2143getSevenEK5gGoQ() {
            return Key.Seven;
        }

        /* JADX INFO: renamed from: getEight-EK5gGoQ, reason: not valid java name */
        public final long m2011getEightEK5gGoQ() {
            return Key.Eight;
        }

        /* JADX INFO: renamed from: getNine-EK5gGoQ, reason: not valid java name */
        public final long m2089getNineEK5gGoQ() {
            return Key.Nine;
        }

        /* JADX INFO: renamed from: getPlus-EK5gGoQ, reason: not valid java name */
        public final long m2122getPlusEK5gGoQ() {
            return Key.Plus;
        }

        /* JADX INFO: renamed from: getMinus-EK5gGoQ, reason: not valid java name */
        public final long m2078getMinusEK5gGoQ() {
            return Key.Minus;
        }

        /* JADX INFO: renamed from: getMultiply-EK5gGoQ, reason: not valid java name */
        public final long m2082getMultiplyEK5gGoQ() {
            return Key.Multiply;
        }

        /* JADX INFO: renamed from: getEquals-EK5gGoQ, reason: not valid java name */
        public final long m2016getEqualsEK5gGoQ() {
            return Key.Equals;
        }

        /* JADX INFO: renamed from: getPound-EK5gGoQ, reason: not valid java name */
        public final long m2123getPoundEK5gGoQ() {
            return Key.Pound;
        }

        /* JADX INFO: renamed from: getA-EK5gGoQ, reason: not valid java name */
        public final long m1932getAEK5gGoQ() {
            return Key.A;
        }

        /* JADX INFO: renamed from: getB-EK5gGoQ, reason: not valid java name */
        public final long m1942getBEK5gGoQ() {
            return Key.B;
        }

        /* JADX INFO: renamed from: getC-EK5gGoQ, reason: not valid java name */
        public final long m1982getCEK5gGoQ() {
            return Key.C;
        }

        /* JADX INFO: renamed from: getD-EK5gGoQ, reason: not valid java name */
        public final long m1998getDEK5gGoQ() {
            return Key.D;
        }

        /* JADX INFO: renamed from: getE-EK5gGoQ, reason: not valid java name */
        public final long m2010getEEK5gGoQ() {
            return Key.E;
        }

        /* JADX INFO: renamed from: getF-EK5gGoQ, reason: not valid java name */
        public final long m2018getFEK5gGoQ() {
            return Key.F;
        }

        /* JADX INFO: renamed from: getG-EK5gGoQ, reason: not valid java name */
        public final long m2036getGEK5gGoQ() {
            return Key.G;
        }

        /* JADX INFO: renamed from: getH-EK5gGoQ, reason: not valid java name */
        public final long m2039getHEK5gGoQ() {
            return Key.H;
        }

        /* JADX INFO: renamed from: getI-EK5gGoQ, reason: not valid java name */
        public final long m2044getIEK5gGoQ() {
            return Key.I;
        }

        /* JADX INFO: renamed from: getJ-EK5gGoQ, reason: not valid java name */
        public final long m2047getJEK5gGoQ() {
            return Key.J;
        }

        /* JADX INFO: renamed from: getK-EK5gGoQ, reason: not valid java name */
        public final long m2048getKEK5gGoQ() {
            return Key.K;
        }

        /* JADX INFO: renamed from: getL-EK5gGoQ, reason: not valid java name */
        public final long m2051getLEK5gGoQ() {
            return Key.L;
        }

        /* JADX INFO: renamed from: getM-EK5gGoQ, reason: not valid java name */
        public final long m2055getMEK5gGoQ() {
            return Key.M;
        }

        /* JADX INFO: renamed from: getN-EK5gGoQ, reason: not valid java name */
        public final long m2084getNEK5gGoQ() {
            return Key.N;
        }

        /* JADX INFO: renamed from: getO-EK5gGoQ, reason: not valid java name */
        public final long m2113getOEK5gGoQ() {
            return Key.O;
        }

        /* JADX INFO: renamed from: getP-EK5gGoQ, reason: not valid java name */
        public final long m2115getPEK5gGoQ() {
            return Key.P;
        }

        /* JADX INFO: renamed from: getQ-EK5gGoQ, reason: not valid java name */
        public final long m2131getQEK5gGoQ() {
            return Key.Q;
        }

        /* JADX INFO: renamed from: getR-EK5gGoQ, reason: not valid java name */
        public final long m2132getREK5gGoQ() {
            return Key.R;
        }

        /* JADX INFO: renamed from: getS-EK5gGoQ, reason: not valid java name */
        public final long m2136getSEK5gGoQ() {
            return Key.S;
        }

        /* JADX INFO: renamed from: getT-EK5gGoQ, reason: not valid java name */
        public final long m2163getTEK5gGoQ() {
            return Key.T;
        }

        /* JADX INFO: renamed from: getU-EK5gGoQ, reason: not valid java name */
        public final long m2201getUEK5gGoQ() {
            return Key.U;
        }

        /* JADX INFO: renamed from: getV-EK5gGoQ, reason: not valid java name */
        public final long m2203getVEK5gGoQ() {
            return Key.V;
        }

        /* JADX INFO: renamed from: getW-EK5gGoQ, reason: not valid java name */
        public final long m2208getWEK5gGoQ() {
            return Key.W;
        }

        /* JADX INFO: renamed from: getX-EK5gGoQ, reason: not valid java name */
        public final long m2211getXEK5gGoQ() {
            return Key.X;
        }

        /* JADX INFO: renamed from: getY-EK5gGoQ, reason: not valid java name */
        public final long m2212getYEK5gGoQ() {
            return Key.Y;
        }

        /* JADX INFO: renamed from: getZ-EK5gGoQ, reason: not valid java name */
        public final long m2214getZEK5gGoQ() {
            return Key.Z;
        }

        /* JADX INFO: renamed from: getComma-EK5gGoQ, reason: not valid java name */
        public final long m1992getCommaEK5gGoQ() {
            return Key.Comma;
        }

        /* JADX INFO: renamed from: getPeriod-EK5gGoQ, reason: not valid java name */
        public final long m2120getPeriodEK5gGoQ() {
            return Key.Period;
        }

        /* JADX INFO: renamed from: getAltLeft-EK5gGoQ, reason: not valid java name */
        public final long m1934getAltLeftEK5gGoQ() {
            return Key.AltLeft;
        }

        /* JADX INFO: renamed from: getAltRight-EK5gGoQ, reason: not valid java name */
        public final long m1935getAltRightEK5gGoQ() {
            return Key.AltRight;
        }

        /* JADX INFO: renamed from: getShiftLeft-EK5gGoQ, reason: not valid java name */
        public final long m2144getShiftLeftEK5gGoQ() {
            return Key.ShiftLeft;
        }

        /* JADX INFO: renamed from: getShiftRight-EK5gGoQ, reason: not valid java name */
        public final long m2145getShiftRightEK5gGoQ() {
            return Key.ShiftRight;
        }

        /* JADX INFO: renamed from: getTab-EK5gGoQ, reason: not valid java name */
        public final long m2164getTabEK5gGoQ() {
            return Key.Tab;
        }

        /* JADX INFO: renamed from: getSpacebar-EK5gGoQ, reason: not valid java name */
        public final long m2152getSpacebarEK5gGoQ() {
            return Key.Spacebar;
        }

        /* JADX INFO: renamed from: getSymbol-EK5gGoQ, reason: not valid java name */
        public final long m2158getSymbolEK5gGoQ() {
            return Key.Symbol;
        }

        /* JADX INFO: renamed from: getBrowser-EK5gGoQ, reason: not valid java name */
        public final long m1950getBrowserEK5gGoQ() {
            return Key.Browser;
        }

        /* JADX INFO: renamed from: getEnvelope-EK5gGoQ, reason: not valid java name */
        public final long m2015getEnvelopeEK5gGoQ() {
            return Key.Envelope;
        }

        /* JADX INFO: renamed from: getEnter-EK5gGoQ, reason: not valid java name */
        public final long m2014getEnterEK5gGoQ() {
            return Key.Enter;
        }

        /* JADX INFO: renamed from: getBackspace-EK5gGoQ, reason: not valid java name */
        public final long m1945getBackspaceEK5gGoQ() {
            return Key.Backspace;
        }

        /* JADX INFO: renamed from: getDelete-EK5gGoQ, reason: not valid java name */
        public final long m1999getDeleteEK5gGoQ() {
            return Key.Delete;
        }

        /* JADX INFO: renamed from: getEscape-EK5gGoQ, reason: not valid java name */
        public final long m2017getEscapeEK5gGoQ() {
            return Key.Escape;
        }

        /* JADX INFO: renamed from: getCtrlLeft-EK5gGoQ, reason: not valid java name */
        public final long m1995getCtrlLeftEK5gGoQ() {
            return Key.CtrlLeft;
        }

        /* JADX INFO: renamed from: getCtrlRight-EK5gGoQ, reason: not valid java name */
        public final long m1996getCtrlRightEK5gGoQ() {
            return Key.CtrlRight;
        }

        /* JADX INFO: renamed from: getCapsLock-EK5gGoQ, reason: not valid java name */
        public final long m1987getCapsLockEK5gGoQ() {
            return Key.CapsLock;
        }

        /* JADX INFO: renamed from: getScrollLock-EK5gGoQ, reason: not valid java name */
        public final long m2137getScrollLockEK5gGoQ() {
            return Key.ScrollLock;
        }

        /* JADX INFO: renamed from: getMetaLeft-EK5gGoQ, reason: not valid java name */
        public final long m2075getMetaLeftEK5gGoQ() {
            return Key.MetaLeft;
        }

        /* JADX INFO: renamed from: getMetaRight-EK5gGoQ, reason: not valid java name */
        public final long m2076getMetaRightEK5gGoQ() {
            return Key.MetaRight;
        }

        /* JADX INFO: renamed from: getFunction-EK5gGoQ, reason: not valid java name */
        public final long m2035getFunctionEK5gGoQ() {
            return Key.Function;
        }

        /* JADX INFO: renamed from: getPrintScreen-EK5gGoQ, reason: not valid java name */
        public final long m2125getPrintScreenEK5gGoQ() {
            return Key.PrintScreen;
        }

        /* JADX INFO: renamed from: getBreak-EK5gGoQ, reason: not valid java name */
        public final long m1947getBreakEK5gGoQ() {
            return Key.Break;
        }

        /* JADX INFO: renamed from: getMoveHome-EK5gGoQ, reason: not valid java name */
        public final long m2080getMoveHomeEK5gGoQ() {
            return Key.MoveHome;
        }

        /* JADX INFO: renamed from: getMoveEnd-EK5gGoQ, reason: not valid java name */
        public final long m2079getMoveEndEK5gGoQ() {
            return Key.MoveEnd;
        }

        /* JADX INFO: renamed from: getInsert-EK5gGoQ, reason: not valid java name */
        public final long m2046getInsertEK5gGoQ() {
            return Key.Insert;
        }

        /* JADX INFO: renamed from: getCut-EK5gGoQ, reason: not valid java name */
        public final long m1997getCutEK5gGoQ() {
            return Key.Cut;
        }

        /* JADX INFO: renamed from: getCopy-EK5gGoQ, reason: not valid java name */
        public final long m1994getCopyEK5gGoQ() {
            return Key.Copy;
        }

        /* JADX INFO: renamed from: getPaste-EK5gGoQ, reason: not valid java name */
        public final long m2119getPasteEK5gGoQ() {
            return Key.Paste;
        }

        /* JADX INFO: renamed from: getGrave-EK5gGoQ, reason: not valid java name */
        public final long m2037getGraveEK5gGoQ() {
            return Key.Grave;
        }

        /* JADX INFO: renamed from: getLeftBracket-EK5gGoQ, reason: not valid java name */
        public final long m2054getLeftBracketEK5gGoQ() {
            return Key.LeftBracket;
        }

        /* JADX INFO: renamed from: getRightBracket-EK5gGoQ, reason: not valid java name */
        public final long m2134getRightBracketEK5gGoQ() {
            return Key.RightBracket;
        }

        /* JADX INFO: renamed from: getSlash-EK5gGoQ, reason: not valid java name */
        public final long m2147getSlashEK5gGoQ() {
            return Key.Slash;
        }

        /* JADX INFO: renamed from: getBackslash-EK5gGoQ, reason: not valid java name */
        public final long m1944getBackslashEK5gGoQ() {
            return Key.Backslash;
        }

        /* JADX INFO: renamed from: getSemicolon-EK5gGoQ, reason: not valid java name */
        public final long m2139getSemicolonEK5gGoQ() {
            return Key.Semicolon;
        }

        /* JADX INFO: renamed from: getApostrophe-EK5gGoQ, reason: not valid java name */
        public final long m1936getApostropheEK5gGoQ() {
            return Key.Apostrophe;
        }

        /* JADX INFO: renamed from: getAt-EK5gGoQ, reason: not valid java name */
        public final long m1939getAtEK5gGoQ() {
            return Key.At;
        }

        /* JADX INFO: renamed from: getNumber-EK5gGoQ, reason: not valid java name */
        public final long m2112getNumberEK5gGoQ() {
            return Key.Number;
        }

        /* JADX INFO: renamed from: getHeadsetHook-EK5gGoQ, reason: not valid java name */
        public final long m2040getHeadsetHookEK5gGoQ() {
            return Key.HeadsetHook;
        }

        /* JADX INFO: renamed from: getFocus-EK5gGoQ, reason: not valid java name */
        public final long m2032getFocusEK5gGoQ() {
            return Key.Focus;
        }

        /* JADX INFO: renamed from: getMenu-EK5gGoQ, reason: not valid java name */
        public final long m2074getMenuEK5gGoQ() {
            return Key.Menu;
        }

        /* JADX INFO: renamed from: getNotification-EK5gGoQ, reason: not valid java name */
        public final long m2090getNotificationEK5gGoQ() {
            return Key.Notification;
        }

        /* JADX INFO: renamed from: getSearch-EK5gGoQ, reason: not valid java name */
        public final long m2138getSearchEK5gGoQ() {
            return Key.Search;
        }

        /* JADX INFO: renamed from: getPageUp-EK5gGoQ, reason: not valid java name */
        public final long m2117getPageUpEK5gGoQ() {
            return Key.PageUp;
        }

        /* JADX INFO: renamed from: getPageDown-EK5gGoQ, reason: not valid java name */
        public final long m2116getPageDownEK5gGoQ() {
            return Key.PageDown;
        }

        /* JADX INFO: renamed from: getPictureSymbols-EK5gGoQ, reason: not valid java name */
        public final long m2121getPictureSymbolsEK5gGoQ() {
            return Key.PictureSymbols;
        }

        /* JADX INFO: renamed from: getSwitchCharset-EK5gGoQ, reason: not valid java name */
        public final long m2157getSwitchCharsetEK5gGoQ() {
            return Key.SwitchCharset;
        }

        /* JADX INFO: renamed from: getButtonA-EK5gGoQ, reason: not valid java name */
        public final long m1967getButtonAEK5gGoQ() {
            return Key.ButtonA;
        }

        /* JADX INFO: renamed from: getButtonB-EK5gGoQ, reason: not valid java name */
        public final long m1968getButtonBEK5gGoQ() {
            return Key.ButtonB;
        }

        /* JADX INFO: renamed from: getButtonC-EK5gGoQ, reason: not valid java name */
        public final long m1969getButtonCEK5gGoQ() {
            return Key.ButtonC;
        }

        /* JADX INFO: renamed from: getButtonX-EK5gGoQ, reason: not valid java name */
        public final long m1979getButtonXEK5gGoQ() {
            return Key.ButtonX;
        }

        /* JADX INFO: renamed from: getButtonY-EK5gGoQ, reason: not valid java name */
        public final long m1980getButtonYEK5gGoQ() {
            return Key.ButtonY;
        }

        /* JADX INFO: renamed from: getButtonZ-EK5gGoQ, reason: not valid java name */
        public final long m1981getButtonZEK5gGoQ() {
            return Key.ButtonZ;
        }

        /* JADX INFO: renamed from: getButtonL1-EK5gGoQ, reason: not valid java name */
        public final long m1970getButtonL1EK5gGoQ() {
            return Key.ButtonL1;
        }

        /* JADX INFO: renamed from: getButtonR1-EK5gGoQ, reason: not valid java name */
        public final long m1973getButtonR1EK5gGoQ() {
            return Key.ButtonR1;
        }

        /* JADX INFO: renamed from: getButtonL2-EK5gGoQ, reason: not valid java name */
        public final long m1971getButtonL2EK5gGoQ() {
            return Key.ButtonL2;
        }

        /* JADX INFO: renamed from: getButtonR2-EK5gGoQ, reason: not valid java name */
        public final long m1974getButtonR2EK5gGoQ() {
            return Key.ButtonR2;
        }

        /* JADX INFO: renamed from: getButtonThumbLeft-EK5gGoQ, reason: not valid java name */
        public final long m1977getButtonThumbLeftEK5gGoQ() {
            return Key.ButtonThumbLeft;
        }

        /* JADX INFO: renamed from: getButtonThumbRight-EK5gGoQ, reason: not valid java name */
        public final long m1978getButtonThumbRightEK5gGoQ() {
            return Key.ButtonThumbRight;
        }

        /* JADX INFO: renamed from: getButtonStart-EK5gGoQ, reason: not valid java name */
        public final long m1976getButtonStartEK5gGoQ() {
            return Key.ButtonStart;
        }

        /* JADX INFO: renamed from: getButtonSelect-EK5gGoQ, reason: not valid java name */
        public final long m1975getButtonSelectEK5gGoQ() {
            return Key.ButtonSelect;
        }

        /* JADX INFO: renamed from: getButtonMode-EK5gGoQ, reason: not valid java name */
        public final long m1972getButtonModeEK5gGoQ() {
            return Key.ButtonMode;
        }

        /* JADX INFO: renamed from: getButton1-EK5gGoQ, reason: not valid java name */
        public final long m1951getButton1EK5gGoQ() {
            return Key.Button1;
        }

        /* JADX INFO: renamed from: getButton2-EK5gGoQ, reason: not valid java name */
        public final long m1959getButton2EK5gGoQ() {
            return Key.Button2;
        }

        /* JADX INFO: renamed from: getButton3-EK5gGoQ, reason: not valid java name */
        public final long m1960getButton3EK5gGoQ() {
            return Key.Button3;
        }

        /* JADX INFO: renamed from: getButton4-EK5gGoQ, reason: not valid java name */
        public final long m1961getButton4EK5gGoQ() {
            return Key.Button4;
        }

        /* JADX INFO: renamed from: getButton5-EK5gGoQ, reason: not valid java name */
        public final long m1962getButton5EK5gGoQ() {
            return Key.Button5;
        }

        /* JADX INFO: renamed from: getButton6-EK5gGoQ, reason: not valid java name */
        public final long m1963getButton6EK5gGoQ() {
            return Key.Button6;
        }

        /* JADX INFO: renamed from: getButton7-EK5gGoQ, reason: not valid java name */
        public final long m1964getButton7EK5gGoQ() {
            return Key.Button7;
        }

        /* JADX INFO: renamed from: getButton8-EK5gGoQ, reason: not valid java name */
        public final long m1965getButton8EK5gGoQ() {
            return Key.Button8;
        }

        /* JADX INFO: renamed from: getButton9-EK5gGoQ, reason: not valid java name */
        public final long m1966getButton9EK5gGoQ() {
            return Key.Button9;
        }

        /* JADX INFO: renamed from: getButton10-EK5gGoQ, reason: not valid java name */
        public final long m1952getButton10EK5gGoQ() {
            return Key.Button10;
        }

        /* JADX INFO: renamed from: getButton11-EK5gGoQ, reason: not valid java name */
        public final long m1953getButton11EK5gGoQ() {
            return Key.Button11;
        }

        /* JADX INFO: renamed from: getButton12-EK5gGoQ, reason: not valid java name */
        public final long m1954getButton12EK5gGoQ() {
            return Key.Button12;
        }

        /* JADX INFO: renamed from: getButton13-EK5gGoQ, reason: not valid java name */
        public final long m1955getButton13EK5gGoQ() {
            return Key.Button13;
        }

        /* JADX INFO: renamed from: getButton14-EK5gGoQ, reason: not valid java name */
        public final long m1956getButton14EK5gGoQ() {
            return Key.Button14;
        }

        /* JADX INFO: renamed from: getButton15-EK5gGoQ, reason: not valid java name */
        public final long m1957getButton15EK5gGoQ() {
            return Key.Button15;
        }

        /* JADX INFO: renamed from: getButton16-EK5gGoQ, reason: not valid java name */
        public final long m1958getButton16EK5gGoQ() {
            return Key.Button16;
        }

        /* JADX INFO: renamed from: getForward-EK5gGoQ, reason: not valid java name */
        public final long m2033getForwardEK5gGoQ() {
            return Key.Forward;
        }

        /* JADX INFO: renamed from: getF1-EK5gGoQ, reason: not valid java name */
        public final long m2019getF1EK5gGoQ() {
            return Key.F1;
        }

        /* JADX INFO: renamed from: getF2-EK5gGoQ, reason: not valid java name */
        public final long m2023getF2EK5gGoQ() {
            return Key.F2;
        }

        /* JADX INFO: renamed from: getF3-EK5gGoQ, reason: not valid java name */
        public final long m2024getF3EK5gGoQ() {
            return Key.F3;
        }

        /* JADX INFO: renamed from: getF4-EK5gGoQ, reason: not valid java name */
        public final long m2025getF4EK5gGoQ() {
            return Key.F4;
        }

        /* JADX INFO: renamed from: getF5-EK5gGoQ, reason: not valid java name */
        public final long m2026getF5EK5gGoQ() {
            return Key.F5;
        }

        /* JADX INFO: renamed from: getF6-EK5gGoQ, reason: not valid java name */
        public final long m2027getF6EK5gGoQ() {
            return Key.F6;
        }

        /* JADX INFO: renamed from: getF7-EK5gGoQ, reason: not valid java name */
        public final long m2028getF7EK5gGoQ() {
            return Key.F7;
        }

        /* JADX INFO: renamed from: getF8-EK5gGoQ, reason: not valid java name */
        public final long m2029getF8EK5gGoQ() {
            return Key.F8;
        }

        /* JADX INFO: renamed from: getF9-EK5gGoQ, reason: not valid java name */
        public final long m2030getF9EK5gGoQ() {
            return Key.F9;
        }

        /* JADX INFO: renamed from: getF10-EK5gGoQ, reason: not valid java name */
        public final long m2020getF10EK5gGoQ() {
            return Key.F10;
        }

        /* JADX INFO: renamed from: getF11-EK5gGoQ, reason: not valid java name */
        public final long m2021getF11EK5gGoQ() {
            return Key.F11;
        }

        /* JADX INFO: renamed from: getF12-EK5gGoQ, reason: not valid java name */
        public final long m2022getF12EK5gGoQ() {
            return Key.F12;
        }

        /* JADX INFO: renamed from: getNumLock-EK5gGoQ, reason: not valid java name */
        public final long m2091getNumLockEK5gGoQ() {
            return Key.NumLock;
        }

        /* JADX INFO: renamed from: getNumPad0-EK5gGoQ, reason: not valid java name */
        public final long m2092getNumPad0EK5gGoQ() {
            return Key.NumPad0;
        }

        /* JADX INFO: renamed from: getNumPad1-EK5gGoQ, reason: not valid java name */
        public final long m2093getNumPad1EK5gGoQ() {
            return Key.NumPad1;
        }

        /* JADX INFO: renamed from: getNumPad2-EK5gGoQ, reason: not valid java name */
        public final long m2094getNumPad2EK5gGoQ() {
            return Key.NumPad2;
        }

        /* JADX INFO: renamed from: getNumPad3-EK5gGoQ, reason: not valid java name */
        public final long m2095getNumPad3EK5gGoQ() {
            return Key.NumPad3;
        }

        /* JADX INFO: renamed from: getNumPad4-EK5gGoQ, reason: not valid java name */
        public final long m2096getNumPad4EK5gGoQ() {
            return Key.NumPad4;
        }

        /* JADX INFO: renamed from: getNumPad5-EK5gGoQ, reason: not valid java name */
        public final long m2097getNumPad5EK5gGoQ() {
            return Key.NumPad5;
        }

        /* JADX INFO: renamed from: getNumPad6-EK5gGoQ, reason: not valid java name */
        public final long m2098getNumPad6EK5gGoQ() {
            return Key.NumPad6;
        }

        /* JADX INFO: renamed from: getNumPad7-EK5gGoQ, reason: not valid java name */
        public final long m2099getNumPad7EK5gGoQ() {
            return Key.NumPad7;
        }

        /* JADX INFO: renamed from: getNumPad8-EK5gGoQ, reason: not valid java name */
        public final long m2100getNumPad8EK5gGoQ() {
            return Key.NumPad8;
        }

        /* JADX INFO: renamed from: getNumPad9-EK5gGoQ, reason: not valid java name */
        public final long m2101getNumPad9EK5gGoQ() {
            return Key.NumPad9;
        }

        /* JADX INFO: renamed from: getNumPadDivide-EK5gGoQ, reason: not valid java name */
        public final long m2104getNumPadDivideEK5gGoQ() {
            return Key.NumPadDivide;
        }

        /* JADX INFO: renamed from: getNumPadMultiply-EK5gGoQ, reason: not valid java name */
        public final long m2109getNumPadMultiplyEK5gGoQ() {
            return Key.NumPadMultiply;
        }

        /* JADX INFO: renamed from: getNumPadSubtract-EK5gGoQ, reason: not valid java name */
        public final long m2111getNumPadSubtractEK5gGoQ() {
            return Key.NumPadSubtract;
        }

        /* JADX INFO: renamed from: getNumPadAdd-EK5gGoQ, reason: not valid java name */
        public final long m2102getNumPadAddEK5gGoQ() {
            return Key.NumPadAdd;
        }

        /* JADX INFO: renamed from: getNumPadDot-EK5gGoQ, reason: not valid java name */
        public final long m2105getNumPadDotEK5gGoQ() {
            return Key.NumPadDot;
        }

        /* JADX INFO: renamed from: getNumPadComma-EK5gGoQ, reason: not valid java name */
        public final long m2103getNumPadCommaEK5gGoQ() {
            return Key.NumPadComma;
        }

        /* JADX INFO: renamed from: getNumPadEnter-EK5gGoQ, reason: not valid java name */
        public final long m2106getNumPadEnterEK5gGoQ() {
            return Key.NumPadEnter;
        }

        /* JADX INFO: renamed from: getNumPadEquals-EK5gGoQ, reason: not valid java name */
        public final long m2107getNumPadEqualsEK5gGoQ() {
            return Key.NumPadEquals;
        }

        /* JADX INFO: renamed from: getNumPadLeftParenthesis-EK5gGoQ, reason: not valid java name */
        public final long m2108getNumPadLeftParenthesisEK5gGoQ() {
            return Key.NumPadLeftParenthesis;
        }

        /* JADX INFO: renamed from: getNumPadRightParenthesis-EK5gGoQ, reason: not valid java name */
        public final long m2110getNumPadRightParenthesisEK5gGoQ() {
            return Key.NumPadRightParenthesis;
        }

        /* JADX INFO: renamed from: getMediaPlay-EK5gGoQ, reason: not valid java name */
        public final long m2063getMediaPlayEK5gGoQ() {
            return Key.MediaPlay;
        }

        /* JADX INFO: renamed from: getMediaPause-EK5gGoQ, reason: not valid java name */
        public final long m2062getMediaPauseEK5gGoQ() {
            return Key.MediaPause;
        }

        /* JADX INFO: renamed from: getMediaPlayPause-EK5gGoQ, reason: not valid java name */
        public final long m2064getMediaPlayPauseEK5gGoQ() {
            return Key.MediaPlayPause;
        }

        /* JADX INFO: renamed from: getMediaStop-EK5gGoQ, reason: not valid java name */
        public final long m2072getMediaStopEK5gGoQ() {
            return Key.MediaStop;
        }

        /* JADX INFO: renamed from: getMediaRecord-EK5gGoQ, reason: not valid java name */
        public final long m2066getMediaRecordEK5gGoQ() {
            return Key.MediaRecord;
        }

        /* JADX INFO: renamed from: getMediaNext-EK5gGoQ, reason: not valid java name */
        public final long m2061getMediaNextEK5gGoQ() {
            return Key.MediaNext;
        }

        /* JADX INFO: renamed from: getMediaPrevious-EK5gGoQ, reason: not valid java name */
        public final long m2065getMediaPreviousEK5gGoQ() {
            return Key.MediaPrevious;
        }

        /* JADX INFO: renamed from: getMediaRewind-EK5gGoQ, reason: not valid java name */
        public final long m2067getMediaRewindEK5gGoQ() {
            return Key.MediaRewind;
        }

        /* JADX INFO: renamed from: getMediaFastForward-EK5gGoQ, reason: not valid java name */
        public final long m2060getMediaFastForwardEK5gGoQ() {
            return Key.MediaFastForward;
        }

        /* JADX INFO: renamed from: getMediaClose-EK5gGoQ, reason: not valid java name */
        public final long m2058getMediaCloseEK5gGoQ() {
            return Key.MediaClose;
        }

        /* JADX INFO: renamed from: getMediaAudioTrack-EK5gGoQ, reason: not valid java name */
        public final long m2057getMediaAudioTrackEK5gGoQ() {
            return Key.MediaAudioTrack;
        }

        /* JADX INFO: renamed from: getMediaEject-EK5gGoQ, reason: not valid java name */
        public final long m2059getMediaEjectEK5gGoQ() {
            return Key.MediaEject;
        }

        /* JADX INFO: renamed from: getMediaTopMenu-EK5gGoQ, reason: not valid java name */
        public final long m2073getMediaTopMenuEK5gGoQ() {
            return Key.MediaTopMenu;
        }

        /* JADX INFO: renamed from: getMediaSkipForward-EK5gGoQ, reason: not valid java name */
        public final long m2069getMediaSkipForwardEK5gGoQ() {
            return Key.MediaSkipForward;
        }

        /* JADX INFO: renamed from: getMediaSkipBackward-EK5gGoQ, reason: not valid java name */
        public final long m2068getMediaSkipBackwardEK5gGoQ() {
            return Key.MediaSkipBackward;
        }

        /* JADX INFO: renamed from: getMediaStepForward-EK5gGoQ, reason: not valid java name */
        public final long m2071getMediaStepForwardEK5gGoQ() {
            return Key.MediaStepForward;
        }

        /* JADX INFO: renamed from: getMediaStepBackward-EK5gGoQ, reason: not valid java name */
        public final long m2070getMediaStepBackwardEK5gGoQ() {
            return Key.MediaStepBackward;
        }

        /* JADX INFO: renamed from: getMicrophoneMute-EK5gGoQ, reason: not valid java name */
        public final long m2077getMicrophoneMuteEK5gGoQ() {
            return Key.MicrophoneMute;
        }

        /* JADX INFO: renamed from: getVolumeMute-EK5gGoQ, reason: not valid java name */
        public final long m2206getVolumeMuteEK5gGoQ() {
            return Key.VolumeMute;
        }

        /* JADX INFO: renamed from: getInfo-EK5gGoQ, reason: not valid java name */
        public final long m2045getInfoEK5gGoQ() {
            return Key.Info;
        }

        /* JADX INFO: renamed from: getChannelUp-EK5gGoQ, reason: not valid java name */
        public final long m1990getChannelUpEK5gGoQ() {
            return Key.ChannelUp;
        }

        /* JADX INFO: renamed from: getChannelDown-EK5gGoQ, reason: not valid java name */
        public final long m1989getChannelDownEK5gGoQ() {
            return Key.ChannelDown;
        }

        /* JADX INFO: renamed from: getZoomIn-EK5gGoQ, reason: not valid java name */
        public final long m2217getZoomInEK5gGoQ() {
            return Key.ZoomIn;
        }

        /* JADX INFO: renamed from: getZoomOut-EK5gGoQ, reason: not valid java name */
        public final long m2218getZoomOutEK5gGoQ() {
            return Key.ZoomOut;
        }

        /* JADX INFO: renamed from: getTv-EK5gGoQ, reason: not valid java name */
        public final long m2169getTvEK5gGoQ() {
            return Key.Tv;
        }

        /* JADX INFO: renamed from: getWindow-EK5gGoQ, reason: not valid java name */
        public final long m2210getWindowEK5gGoQ() {
            return Key.Window;
        }

        /* JADX INFO: renamed from: getGuide-EK5gGoQ, reason: not valid java name */
        public final long m2038getGuideEK5gGoQ() {
            return Key.Guide;
        }

        /* JADX INFO: renamed from: getDvr-EK5gGoQ, reason: not valid java name */
        public final long m2009getDvrEK5gGoQ() {
            return Key.Dvr;
        }

        /* JADX INFO: renamed from: getBookmark-EK5gGoQ, reason: not valid java name */
        public final long m1946getBookmarkEK5gGoQ() {
            return Key.Bookmark;
        }

        /* JADX INFO: renamed from: getCaptions-EK5gGoQ, reason: not valid java name */
        public final long m1988getCaptionsEK5gGoQ() {
            return Key.Captions;
        }

        /* JADX INFO: renamed from: getSettings-EK5gGoQ, reason: not valid java name */
        public final long m2142getSettingsEK5gGoQ() {
            return Key.Settings;
        }

        /* JADX INFO: renamed from: getTvPower-EK5gGoQ, reason: not valid java name */
        public final long m2189getTvPowerEK5gGoQ() {
            return Key.TvPower;
        }

        /* JADX INFO: renamed from: getTvInput-EK5gGoQ, reason: not valid java name */
        public final long m2176getTvInputEK5gGoQ() {
            return Key.TvInput;
        }

        /* JADX INFO: renamed from: getSetTopBoxPower-EK5gGoQ, reason: not valid java name */
        public final long m2141getSetTopBoxPowerEK5gGoQ() {
            return Key.SetTopBoxPower;
        }

        /* JADX INFO: renamed from: getSetTopBoxInput-EK5gGoQ, reason: not valid java name */
        public final long m2140getSetTopBoxInputEK5gGoQ() {
            return Key.SetTopBoxInput;
        }

        /* JADX INFO: renamed from: getAvReceiverPower-EK5gGoQ, reason: not valid java name */
        public final long m1941getAvReceiverPowerEK5gGoQ() {
            return Key.AvReceiverPower;
        }

        /* JADX INFO: renamed from: getAvReceiverInput-EK5gGoQ, reason: not valid java name */
        public final long m1940getAvReceiverInputEK5gGoQ() {
            return Key.AvReceiverInput;
        }

        /* JADX INFO: renamed from: getProgramRed-EK5gGoQ, reason: not valid java name */
        public final long m2129getProgramRedEK5gGoQ() {
            return Key.ProgramRed;
        }

        /* JADX INFO: renamed from: getProgramGreen-EK5gGoQ, reason: not valid java name */
        public final long m2128getProgramGreenEK5gGoQ() {
            return Key.ProgramGreen;
        }

        /* JADX INFO: renamed from: getProgramYellow-EK5gGoQ, reason: not valid java name */
        public final long m2130getProgramYellowEK5gGoQ() {
            return Key.ProgramYellow;
        }

        /* JADX INFO: renamed from: getProgramBlue-EK5gGoQ, reason: not valid java name */
        public final long m2127getProgramBlueEK5gGoQ() {
            return Key.ProgramBlue;
        }

        /* JADX INFO: renamed from: getAppSwitch-EK5gGoQ, reason: not valid java name */
        public final long m1937getAppSwitchEK5gGoQ() {
            return Key.AppSwitch;
        }

        /* JADX INFO: renamed from: getLanguageSwitch-EK5gGoQ, reason: not valid java name */
        public final long m2052getLanguageSwitchEK5gGoQ() {
            return Key.LanguageSwitch;
        }

        /* JADX INFO: renamed from: getMannerMode-EK5gGoQ, reason: not valid java name */
        public final long m2056getMannerModeEK5gGoQ() {
            return Key.MannerMode;
        }

        /* JADX INFO: renamed from: getToggle2D3D-EK5gGoQ, reason: not valid java name */
        public final long m2168getToggle2D3DEK5gGoQ() {
            return Key.Toggle2D3D;
        }

        /* JADX INFO: renamed from: getContacts-EK5gGoQ, reason: not valid java name */
        public final long m1993getContactsEK5gGoQ() {
            return Key.Contacts;
        }

        /* JADX INFO: renamed from: getCalendar-EK5gGoQ, reason: not valid java name */
        public final long m1984getCalendarEK5gGoQ() {
            return Key.Calendar;
        }

        /* JADX INFO: renamed from: getMusic-EK5gGoQ, reason: not valid java name */
        public final long m2083getMusicEK5gGoQ() {
            return Key.Music;
        }

        /* JADX INFO: renamed from: getCalculator-EK5gGoQ, reason: not valid java name */
        public final long m1983getCalculatorEK5gGoQ() {
            return Key.Calculator;
        }

        /* JADX INFO: renamed from: getZenkakuHankaru-EK5gGoQ, reason: not valid java name */
        public final long m2215getZenkakuHankaruEK5gGoQ() {
            return Key.ZenkakuHankaru;
        }

        /* JADX INFO: renamed from: getEisu-EK5gGoQ, reason: not valid java name */
        public final long m2012getEisuEK5gGoQ() {
            return Key.Eisu;
        }

        /* JADX INFO: renamed from: getMuhenkan-EK5gGoQ, reason: not valid java name */
        public final long m2081getMuhenkanEK5gGoQ() {
            return Key.Muhenkan;
        }

        /* JADX INFO: renamed from: getHenkan-EK5gGoQ, reason: not valid java name */
        public final long m2042getHenkanEK5gGoQ() {
            return Key.Henkan;
        }

        /* JADX INFO: renamed from: getKatakanaHiragana-EK5gGoQ, reason: not valid java name */
        public final long m2050getKatakanaHiraganaEK5gGoQ() {
            return Key.KatakanaHiragana;
        }

        /* JADX INFO: renamed from: getYen-EK5gGoQ, reason: not valid java name */
        public final long m2213getYenEK5gGoQ() {
            return Key.Yen;
        }

        /* JADX INFO: renamed from: getRo-EK5gGoQ, reason: not valid java name */
        public final long m2135getRoEK5gGoQ() {
            return Key.Ro;
        }

        /* JADX INFO: renamed from: getKana-EK5gGoQ, reason: not valid java name */
        public final long m2049getKanaEK5gGoQ() {
            return Key.Kana;
        }

        /* JADX INFO: renamed from: getAssist-EK5gGoQ, reason: not valid java name */
        public final long m1938getAssistEK5gGoQ() {
            return Key.Assist;
        }

        /* JADX INFO: renamed from: getBrightnessDown-EK5gGoQ, reason: not valid java name */
        public final long m1948getBrightnessDownEK5gGoQ() {
            return Key.BrightnessDown;
        }

        /* JADX INFO: renamed from: getBrightnessUp-EK5gGoQ, reason: not valid java name */
        public final long m1949getBrightnessUpEK5gGoQ() {
            return Key.BrightnessUp;
        }

        /* JADX INFO: renamed from: getSleep-EK5gGoQ, reason: not valid java name */
        public final long m2148getSleepEK5gGoQ() {
            return Key.Sleep;
        }

        /* JADX INFO: renamed from: getWakeUp-EK5gGoQ, reason: not valid java name */
        public final long m2209getWakeUpEK5gGoQ() {
            return Key.WakeUp;
        }

        /* JADX INFO: renamed from: getSoftSleep-EK5gGoQ, reason: not valid java name */
        public final long m2151getSoftSleepEK5gGoQ() {
            return Key.SoftSleep;
        }

        /* JADX INFO: renamed from: getPairing-EK5gGoQ, reason: not valid java name */
        public final long m2118getPairingEK5gGoQ() {
            return Key.Pairing;
        }

        /* JADX INFO: renamed from: getLastChannel-EK5gGoQ, reason: not valid java name */
        public final long m2053getLastChannelEK5gGoQ() {
            return Key.LastChannel;
        }

        /* JADX INFO: renamed from: getTvDataService-EK5gGoQ, reason: not valid java name */
        public final long m2175getTvDataServiceEK5gGoQ() {
            return Key.TvDataService;
        }

        /* JADX INFO: renamed from: getVoiceAssist-EK5gGoQ, reason: not valid java name */
        public final long m2204getVoiceAssistEK5gGoQ() {
            return Key.VoiceAssist;
        }

        /* JADX INFO: renamed from: getTvRadioService-EK5gGoQ, reason: not valid java name */
        public final long m2190getTvRadioServiceEK5gGoQ() {
            return Key.TvRadioService;
        }

        /* JADX INFO: renamed from: getTvTeletext-EK5gGoQ, reason: not valid java name */
        public final long m2195getTvTeletextEK5gGoQ() {
            return Key.TvTeletext;
        }

        /* JADX INFO: renamed from: getTvNumberEntry-EK5gGoQ, reason: not valid java name */
        public final long m2188getTvNumberEntryEK5gGoQ() {
            return Key.TvNumberEntry;
        }

        /* JADX INFO: renamed from: getTvTerrestrialAnalog-EK5gGoQ, reason: not valid java name */
        public final long m2196getTvTerrestrialAnalogEK5gGoQ() {
            return Key.TvTerrestrialAnalog;
        }

        /* JADX INFO: renamed from: getTvTerrestrialDigital-EK5gGoQ, reason: not valid java name */
        public final long m2197getTvTerrestrialDigitalEK5gGoQ() {
            return Key.TvTerrestrialDigital;
        }

        /* JADX INFO: renamed from: getTvSatellite-EK5gGoQ, reason: not valid java name */
        public final long m2191getTvSatelliteEK5gGoQ() {
            return Key.TvSatellite;
        }

        /* JADX INFO: renamed from: getTvSatelliteBs-EK5gGoQ, reason: not valid java name */
        public final long m2192getTvSatelliteBsEK5gGoQ() {
            return Key.TvSatelliteBs;
        }

        /* JADX INFO: renamed from: getTvSatelliteCs-EK5gGoQ, reason: not valid java name */
        public final long m2193getTvSatelliteCsEK5gGoQ() {
            return Key.TvSatelliteCs;
        }

        /* JADX INFO: renamed from: getTvSatelliteService-EK5gGoQ, reason: not valid java name */
        public final long m2194getTvSatelliteServiceEK5gGoQ() {
            return Key.TvSatelliteService;
        }

        /* JADX INFO: renamed from: getTvNetwork-EK5gGoQ, reason: not valid java name */
        public final long m2187getTvNetworkEK5gGoQ() {
            return Key.TvNetwork;
        }

        /* JADX INFO: renamed from: getTvAntennaCable-EK5gGoQ, reason: not valid java name */
        public final long m2170getTvAntennaCableEK5gGoQ() {
            return Key.TvAntennaCable;
        }

        /* JADX INFO: renamed from: getTvInputHdmi1-EK5gGoQ, reason: not valid java name */
        public final long m2181getTvInputHdmi1EK5gGoQ() {
            return Key.TvInputHdmi1;
        }

        /* JADX INFO: renamed from: getTvInputHdmi2-EK5gGoQ, reason: not valid java name */
        public final long m2182getTvInputHdmi2EK5gGoQ() {
            return Key.TvInputHdmi2;
        }

        /* JADX INFO: renamed from: getTvInputHdmi3-EK5gGoQ, reason: not valid java name */
        public final long m2183getTvInputHdmi3EK5gGoQ() {
            return Key.TvInputHdmi3;
        }

        /* JADX INFO: renamed from: getTvInputHdmi4-EK5gGoQ, reason: not valid java name */
        public final long m2184getTvInputHdmi4EK5gGoQ() {
            return Key.TvInputHdmi4;
        }

        /* JADX INFO: renamed from: getTvInputComposite1-EK5gGoQ, reason: not valid java name */
        public final long m2179getTvInputComposite1EK5gGoQ() {
            return Key.TvInputComposite1;
        }

        /* JADX INFO: renamed from: getTvInputComposite2-EK5gGoQ, reason: not valid java name */
        public final long m2180getTvInputComposite2EK5gGoQ() {
            return Key.TvInputComposite2;
        }

        /* JADX INFO: renamed from: getTvInputComponent1-EK5gGoQ, reason: not valid java name */
        public final long m2177getTvInputComponent1EK5gGoQ() {
            return Key.TvInputComponent1;
        }

        /* JADX INFO: renamed from: getTvInputComponent2-EK5gGoQ, reason: not valid java name */
        public final long m2178getTvInputComponent2EK5gGoQ() {
            return Key.TvInputComponent2;
        }

        /* JADX INFO: renamed from: getTvInputVga1-EK5gGoQ, reason: not valid java name */
        public final long m2185getTvInputVga1EK5gGoQ() {
            return Key.TvInputVga1;
        }

        /* JADX INFO: renamed from: getTvAudioDescription-EK5gGoQ, reason: not valid java name */
        public final long m2171getTvAudioDescriptionEK5gGoQ() {
            return Key.TvAudioDescription;
        }

        /* JADX INFO: renamed from: getTvAudioDescriptionMixingVolumeUp-EK5gGoQ, reason: not valid java name */
        public final long m2173getTvAudioDescriptionMixingVolumeUpEK5gGoQ() {
            return Key.TvAudioDescriptionMixingVolumeUp;
        }

        /* JADX INFO: renamed from: getTvAudioDescriptionMixingVolumeDown-EK5gGoQ, reason: not valid java name */
        public final long m2172getTvAudioDescriptionMixingVolumeDownEK5gGoQ() {
            return Key.TvAudioDescriptionMixingVolumeDown;
        }

        /* JADX INFO: renamed from: getTvZoomMode-EK5gGoQ, reason: not valid java name */
        public final long m2199getTvZoomModeEK5gGoQ() {
            return Key.TvZoomMode;
        }

        /* JADX INFO: renamed from: getTvContentsMenu-EK5gGoQ, reason: not valid java name */
        public final long m2174getTvContentsMenuEK5gGoQ() {
            return Key.TvContentsMenu;
        }

        /* JADX INFO: renamed from: getTvMediaContextMenu-EK5gGoQ, reason: not valid java name */
        public final long m2186getTvMediaContextMenuEK5gGoQ() {
            return Key.TvMediaContextMenu;
        }

        /* JADX INFO: renamed from: getTvTimerProgramming-EK5gGoQ, reason: not valid java name */
        public final long m2198getTvTimerProgrammingEK5gGoQ() {
            return Key.TvTimerProgramming;
        }

        /* JADX INFO: renamed from: getStemPrimary-EK5gGoQ, reason: not valid java name */
        public final long m2156getStemPrimaryEK5gGoQ() {
            return Key.StemPrimary;
        }

        /* JADX INFO: renamed from: getStem1-EK5gGoQ, reason: not valid java name */
        public final long m2153getStem1EK5gGoQ() {
            return Key.Stem1;
        }

        /* JADX INFO: renamed from: getStem2-EK5gGoQ, reason: not valid java name */
        public final long m2154getStem2EK5gGoQ() {
            return Key.Stem2;
        }

        /* JADX INFO: renamed from: getStem3-EK5gGoQ, reason: not valid java name */
        public final long m2155getStem3EK5gGoQ() {
            return Key.Stem3;
        }

        /* JADX INFO: renamed from: getAllApps-EK5gGoQ, reason: not valid java name */
        public final long m1933getAllAppsEK5gGoQ() {
            return Key.AllApps;
        }

        /* JADX INFO: renamed from: getRefresh-EK5gGoQ, reason: not valid java name */
        public final long m2133getRefreshEK5gGoQ() {
            return Key.Refresh;
        }

        /* JADX INFO: renamed from: getThumbsUp-EK5gGoQ, reason: not valid java name */
        public final long m2167getThumbsUpEK5gGoQ() {
            return Key.ThumbsUp;
        }

        /* JADX INFO: renamed from: getThumbsDown-EK5gGoQ, reason: not valid java name */
        public final long m2166getThumbsDownEK5gGoQ() {
            return Key.ThumbsDown;
        }

        /* JADX INFO: renamed from: getProfileSwitch-EK5gGoQ, reason: not valid java name */
        public final long m2126getProfileSwitchEK5gGoQ() {
            return Key.ProfileSwitch;
        }
    }

    private /* synthetic */ Key(long j) {
        this.keyCode = j;
    }

    public final long getKeyCode() {
        return this.keyCode;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1930toStringimpl(long j) {
        return "Key code: " + j;
    }

    public String toString() {
        return m1930toStringimpl(this.keyCode);
    }
}
