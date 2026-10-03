package com.salesforce.marketingcloud.sfmcsdk.components.storage;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.salesforce.marketingcloud.sfmcsdk.SFMCSdkComponents;
import com.salesforce.marketingcloud.sfmcsdk.util.FileUtilsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public abstract class SFMCSdkSQLiteOpenHelper extends SQLiteOpenHelper {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SFMCSdkSQLiteOpenHelper(@NotNull String databaseName, int i, @NotNull SFMCSdkComponents components) {
        super(components.getContext$sfmcsdk_release(), FileUtilsKt.getFilenameForModuleInstallation(databaseName, components.getModuleApplicationId(), components.getRegistrationId()), (SQLiteDatabase.CursorFactory) null, i);
        Intrinsics.checkNotNullParameter(databaseName, "databaseName");
        Intrinsics.checkNotNullParameter(components, "components");
    }
}
