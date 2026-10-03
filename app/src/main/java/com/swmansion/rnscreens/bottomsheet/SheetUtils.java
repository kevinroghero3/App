package com.swmansion.rnscreens.bottomsheet;

/* JADX INFO: loaded from: classes3.dex */
public final class SheetUtils {
    public static final SheetUtils INSTANCE = new SheetUtils();

    public final boolean isStateLessEqualThan(int i, int i2) {
        if (i == i2) {
            return true;
        }
        if (i != 6 && i2 != 6) {
            return i > i2;
        }
        if (i == 6) {
            return i2 == 3;
        }
        return i == 4 && i2 != 5;
    }

    public final boolean isStateStable(int i) {
        return i == 3 || i == 4 || i == 5 || i == 6;
    }

    private SheetUtils() {
    }

    public final int sheetStateFromDetentIndex(int i, int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    throw new IllegalArgumentException("[RNScreens] Invalid detentCount/index combination " + i2 + " / " + i);
                }
                if (i != -1) {
                    if (i != 0) {
                        if (i == 1) {
                            return 6;
                        }
                        if (i == 2) {
                            return 3;
                        }
                        throw new IllegalArgumentException("[RNScreens] Invalid detentCount/index combination " + i2 + " / " + i);
                    }
                    return 4;
                }
            } else if (i != -1) {
                if (i != 0) {
                    if (i == 1) {
                        return 3;
                    }
                    throw new IllegalArgumentException("[RNScreens] Invalid detentCount/index combination " + i2 + " / " + i);
                }
                return 4;
            }
        } else if (i != -1) {
            if (i == 0) {
                return 3;
            }
            throw new IllegalArgumentException("[RNScreens] Invalid detentCount/index combination " + i2 + " / " + i);
        }
        return 5;
    }

    public final int detentIndexFromSheetState(int i, int i2) {
        if (i2 == 1) {
            if (i != 3) {
                if (i != 5) {
                    throw new IllegalArgumentException("[RNScreens] Invalid state " + i + " for detentCount " + i2);
                }
                return -1;
            }
            return 0;
        }
        if (i2 == 2) {
            if (i == 3) {
                return 1;
            }
            if (i != 4) {
                if (i != 5) {
                    throw new IllegalArgumentException("[RNScreens] Invalid state " + i + " for detentCount " + i2);
                }
                return -1;
            }
            return 0;
        }
        if (i2 != 3) {
            throw new IllegalArgumentException("[RNScreens] Invalid state " + i + " for detentCount " + i2);
        }
        if (i == 3) {
            return 2;
        }
        if (i != 4) {
            if (i != 5) {
                if (i == 6) {
                    return 1;
                }
                throw new IllegalArgumentException("[RNScreens] Invalid state " + i + " for detentCount " + i2);
            }
            return -1;
        }
        return 0;
    }
}
