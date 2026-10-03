package net.time4j.tz.olson;

/* JADX INFO: loaded from: classes6.dex */
public enum AUSTRALIA implements StdZoneIdentifier {
    ADELAIDE("Adelaide"),
    BRISBANE("Brisbane"),
    BROKEN_HILL("Broken_Hill"),
    CURRIE("Currie"),
    DARWIN("Darwin"),
    EUCLA("Eucla"),
    HOBART("Hobart"),
    LINDEMAN("Lindeman"),
    LORD_HOWE("Lord_Howe"),
    MELBOURNE("Melbourne"),
    PERTH("Perth"),
    SYDNEY("Sydney");

    private final String city;
    private final String id;

    AUSTRALIA(String str) {
        this.id = "Australia/" + str;
        this.city = str;
    }

    @Override // net.time4j.tz.TZID
    public String canonical() {
        return this.id;
    }

    @Override // net.time4j.tz.olson.StdZoneIdentifier
    public String getRegion() {
        return "Australia";
    }

    @Override // net.time4j.tz.olson.StdZoneIdentifier
    public String getCity() {
        return this.city;
    }

    @Override // net.time4j.tz.olson.StdZoneIdentifier
    public String getCountry() {
        return "AU";
    }
}
