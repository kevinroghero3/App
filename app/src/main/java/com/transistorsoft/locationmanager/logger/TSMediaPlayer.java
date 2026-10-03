package com.transistorsoft.locationmanager.logger;

import android.content.Context;
import android.media.MediaPlayer;
import app.notifee.core.event.LogEvent;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class TSMediaPlayer {
    public static final String BEEP_OFF = "tslocationmanager_beep_off";
    public static final String BEEP_ON = "tslocationmanager_beep_on";
    public static final String BEEP_TRIP_DRY = "tslocationmanager_beep_trip_dry";
    public static final String BEEP_TRIP_UP_DRY = "tslocationmanager_beep_trip_up_dry";
    public static final String BEEP_TRIP_UP_ECHO = "tslocationmanager_beep_trip_up_echo";
    public static final String BELL_DING_POP = "tslocationmanager_bell_ding_pop";
    public static final String BUTTON_CLICK = "tslocationmanager_click_tap_done_checkbox1";
    public static final String CHIME_BELL_CONFIRM = "tslocationmanager_chime_bell_confirm";
    public static final String CHIME_SHORT_CHORD_UP = "tslocationmanager_chime_short_chord_up";
    public static final String CHIME_SHORT_OFF = "tslocationmanager_chime_short_off";
    public static final String CHIME_SHORT_ON = "tslocationmanager_chime_short_on";
    public static final String CLICK_TAP_DONE = "tslocationmanager_click_tap_done_checkbox5_full_vol";
    public static final String CLOCK_TICK = "tslocationmanager_click_clock_tick";
    public static final String CLOCK_TOCK = "tslocationmanager_click_clock_tock";
    public static final String CLOSE = "tslocationmanager_tiny_retry_failure1";
    public static final String DIGI_WARN = "tslocationmanager_digi_warn";
    public static final String DOT_RETRY = "tslocationmanager_dot_retry";
    public static final String DOT_START = "tslocationmanager_dot_startaction1";
    public static final String DOT_STOP = "tslocationmanager_dot_stopaction2";
    public static final String DOT_SUCCESS = "tslocationmanager_dot_success";
    public static final String ERROR = "tslocationmanager_music_timpani_error_01";
    public static final String GEOFENCE_DWELL = "tslocationmanager_beep_trip_up_echo";
    public static final String GEOFENCE_ENTER = "tslocationmanager_beep_trip_up_dry";
    public static final String GEOFENCE_EXIT = "tslocationmanager_beep_trip_dry";
    public static final String HEARTBEAT = "tslocationmanager_peep_note1";
    public static final String LOCATION_ERROR = "tslocationmanager_digi_warn";
    public static final String LOCATION_RECORDED = "tslocationmanager_ooooiii3_full_vol";
    public static final String LOCATION_SAMPLE = "tslocationmanager_click_tap_done_checkbox5_full_vol";
    public static final String MARIMBA_DROP = "tslocationmanager_marimba_drop";
    public static final String MOTIONCHANGE_FALSE = "tslocationmanager_marimba_drop";
    public static final String MOTIONCHANGE_TRUE = "tslocationmanager_chime_short_chord_up";
    public static final String MUSIC_TIMPANI_ERROR = "tslocationmanager_music_timpani_error_01";
    public static final String OOOOIII = "tslocationmanager_ooooiii3_full_vol";
    public static final String OPEN = "tslocationmanager_tiny_retry_failure3";
    public static final String PEEP_NOTE = "tslocationmanager_peep_note1";
    public static final String PIPE_ALERT = "tslocationmanager_music_pipe_chord";
    public static final String PIPE_CLOSE = "tslocationmanager_music_pipe_cancel";
    public static final String PIPE_CONFIRM = "tslocationmanager_music_pipe_confirm";
    public static final String PIPE_OPEN = "tslocationmanager_music_pipe_chord_nice";
    public static final String POLYGON_ENCLOSING_CIRCLE_ENTER = "tslocationmanager_chime_short_on";
    public static final String POLYGON_ENCLOSING_CIRCLE_EXIT = "tslocationmanager_chime_short_off";
    public static final String POP = "tslocationmanager_pop_notification4";
    public static final String POP_CLOSE = "tslocationmanager_pop_notification2";
    public static final String POP_OPEN = "tslocationmanager_pop_notification1";
    public static final String STATIONARY_GEOFENCE_EXIT = "tslocationmanager_zap_fast";
    public static final String STOP_TIMER_OFF = "tslocationmanager_bell_ding_pop";
    public static final String STOP_TIMER_ON = "tslocationmanager_chime_bell_confirm";
    public static final String TINY_RETRY_FAILURE1 = "tslocationmanager_tiny_retry_failure1";
    public static final String TINY_RETRY_FAILURE3 = "tslocationmanager_tiny_retry_failure3";
    public static final String WARNING = "tslocationmanager_digi_warn";
    public static final String WHOO_SEND_SHARE = "tslocationmanager_whoo_send_share1";
    public static final String ZAP_FAST = "tslocationmanager_zap_fast";
    private static TSMediaPlayer a;
    private MediaPlayer b;
    private final AtomicBoolean c = new AtomicBoolean(false);
    private final AtomicBoolean d = new AtomicBoolean(false);
    private final List<Integer> e = new ArrayList();

    private static TSMediaPlayer a() {
        TSMediaPlayer tSMediaPlayer;
        synchronized (TSMediaPlayer.class) {
            if (a == null) {
                a = new TSMediaPlayer();
            }
            tSMediaPlayer = a;
        }
        return tSMediaPlayer;
    }

    public static TSMediaPlayer getInstance() {
        if (a == null) {
            a = a();
        }
        return a;
    }

    public void debug(Context context, String str) {
        if (this.c.get()) {
            play(context, str);
        }
    }

    public void init(Context context) {
        TSConfig tSConfig = TSConfig.getInstance(context);
        this.c.set(tSConfig.getDebug().booleanValue());
        tSConfig.onChange(LogEvent.LEVEL_DEBUG, new TSConfig.OnChangeCallback() { // from class: com.transistorsoft.locationmanager.logger.TSMediaPlayer$$ExternalSyntheticLambda1
            @Override // com.transistorsoft.locationmanager.adapter.TSConfig.OnChangeCallback
            public final void onChange(TSConfig tSConfig2) {
                this.f$0.a(tSConfig2);
            }
        });
    }

    public void play(Context context, String str) {
        String upperCase = str.toUpperCase();
        try {
            synchronized (this.e) {
                this.e.add(Integer.valueOf(a(context, upperCase)));
                if (this.e.size() > 5) {
                    this.e.remove(0);
                }
            }
            if (this.d.get()) {
                return;
            }
            this.d.set(true);
            run(context);
        } catch (Exception unused) {
            TSLog.logger.debug("‼️   Unknown sound key: " + upperCase);
        }
    }

    public void run(final Context context) {
        int iIntValue;
        synchronized (this.e) {
            iIntValue = this.e.remove(0).intValue();
        }
        MediaPlayer mediaPlayerCreate = MediaPlayer.create(context, iIntValue);
        this.b = mediaPlayerCreate;
        mediaPlayerCreate.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.transistorsoft.locationmanager.logger.TSMediaPlayer$$ExternalSyntheticLambda0
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer) {
                this.f$0.a(context, mediaPlayer);
            }
        });
        this.b.start();
    }

    public void tickTock(Context context, boolean z) {
        synchronized (this.e) {
            this.e.add(Integer.valueOf(a(context, CLOCK_TOCK)));
        }
        if (!z || this.c.get()) {
            play(context, CLOCK_TICK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(TSConfig tSConfig) {
        this.c.set(tSConfig.getDebug().booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Context context, MediaPlayer mediaPlayer) {
        boolean zIsEmpty;
        this.b.release();
        this.b = null;
        synchronized (this.e) {
            zIsEmpty = this.e.isEmpty();
        }
        if (!zIsEmpty) {
            run(context);
        } else {
            this.d.set(false);
        }
    }

    private int a(Context context, String str) {
        return context.getResources().getIdentifier(str.toLowerCase(), "raw", context.getPackageName());
    }
}
