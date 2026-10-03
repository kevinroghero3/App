package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class JavaFeaturesProto {
    public static final int JAVA_FIELD_NUMBER = 1001;
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.FeatureSet, JavaFeatures> java_ = GeneratedMessageLite.newSingularGeneratedExtension(DescriptorProtos.FeatureSet.getDefaultInstance(), JavaFeatures.getDefaultInstance(), JavaFeatures.getDefaultInstance(), null, 1001, WireFormat.FieldType.MESSAGE, JavaFeatures.class);

    public interface JavaFeaturesOrBuilder extends MessageLiteOrBuilder {
        boolean getLargeEnum();

        boolean getLegacyClosedEnum();

        JavaFeatures.NestInFileClassFeature.NestInFileClass getNestInFileClass();

        boolean getUseOldOuterClassnameDefault();

        JavaFeatures.Utf8Validation getUtf8Validation();

        boolean hasLargeEnum();

        boolean hasLegacyClosedEnum();

        boolean hasNestInFileClass();

        boolean hasUseOldOuterClassnameDefault();

        boolean hasUtf8Validation();
    }

    private JavaFeaturesProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.add((GeneratedMessageLite.GeneratedExtension<?, ?>) java_);
    }

    public static final class JavaFeatures extends GeneratedMessageLite<JavaFeatures, Builder> implements JavaFeaturesOrBuilder {
        private static final JavaFeatures DEFAULT_INSTANCE;
        public static final int LARGE_ENUM_FIELD_NUMBER = 3;
        public static final int LEGACY_CLOSED_ENUM_FIELD_NUMBER = 1;
        public static final int NEST_IN_FILE_CLASS_FIELD_NUMBER = 5;
        private static volatile Parser<JavaFeatures> PARSER = null;
        public static final int USE_OLD_OUTER_CLASSNAME_DEFAULT_FIELD_NUMBER = 4;
        public static final int UTF8_VALIDATION_FIELD_NUMBER = 2;
        private int bitField0_;
        private boolean largeEnum_;
        private boolean legacyClosedEnum_;
        private int nestInFileClass_;
        private boolean useOldOuterClassnameDefault_;
        private int utf8Validation_;

        public interface NestInFileClassFeatureOrBuilder extends MessageLiteOrBuilder {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite, com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite, com.google.crypto.tink.shaded.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return super.newBuilderForType();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite, com.google.crypto.tink.shaded.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return super.toBuilder();
        }

        private JavaFeatures() {
        }

        public enum Utf8Validation implements Internal.EnumLite {
            UTF8_VALIDATION_UNKNOWN(0),
            DEFAULT(1),
            VERIFY(2);

            public static final int DEFAULT_VALUE = 1;
            public static final int UTF8_VALIDATION_UNKNOWN_VALUE = 0;
            public static final int VERIFY_VALUE = 2;
            private static final Internal.EnumLiteMap<Utf8Validation> internalValueMap = new Internal.EnumLiteMap<Utf8Validation>() { // from class: com.google.crypto.tink.shaded.protobuf.JavaFeaturesProto.JavaFeatures.Utf8Validation.1
                @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
                public Utf8Validation findValueByNumber(int i) {
                    return Utf8Validation.forNumber(i);
                }
            };
            private final int value;

            @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static Utf8Validation valueOf(int i) {
                return forNumber(i);
            }

            public static Utf8Validation forNumber(int i) {
                if (i == 0) {
                    return UTF8_VALIDATION_UNKNOWN;
                }
                if (i == 1) {
                    return DEFAULT;
                }
                if (i != 2) {
                    return null;
                }
                return VERIFY;
            }

            public static Internal.EnumLiteMap<Utf8Validation> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return Utf8ValidationVerifier.INSTANCE;
            }

            static final class Utf8ValidationVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new Utf8ValidationVerifier();

                private Utf8ValidationVerifier() {
                }

                @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i) {
                    return Utf8Validation.forNumber(i) != null;
                }
            }

            Utf8Validation(int i) {
                this.value = i;
            }
        }

        public static final class NestInFileClassFeature extends GeneratedMessageLite<NestInFileClassFeature, Builder> implements NestInFileClassFeatureOrBuilder {
            private static final NestInFileClassFeature DEFAULT_INSTANCE;
            private static volatile Parser<NestInFileClassFeature> PARSER;

            @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite, com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return super.getDefaultInstanceForType();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite, com.google.crypto.tink.shaded.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return super.newBuilderForType();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite, com.google.crypto.tink.shaded.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return super.toBuilder();
            }

            private NestInFileClassFeature() {
            }

            public enum NestInFileClass implements Internal.EnumLite {
                NEST_IN_FILE_CLASS_UNKNOWN(0),
                NO(1),
                YES(2),
                LEGACY(3);

                public static final int LEGACY_VALUE = 3;
                public static final int NEST_IN_FILE_CLASS_UNKNOWN_VALUE = 0;
                public static final int NO_VALUE = 1;
                public static final int YES_VALUE = 2;
                private static final Internal.EnumLiteMap<NestInFileClass> internalValueMap = new Internal.EnumLiteMap<NestInFileClass>() { // from class: com.google.crypto.tink.shaded.protobuf.JavaFeaturesProto.JavaFeatures.NestInFileClassFeature.NestInFileClass.1
                    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
                    public NestInFileClass findValueByNumber(int i) {
                        return NestInFileClass.forNumber(i);
                    }
                };
                private final int value;

                @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                @Deprecated
                public static NestInFileClass valueOf(int i) {
                    return forNumber(i);
                }

                public static NestInFileClass forNumber(int i) {
                    if (i == 0) {
                        return NEST_IN_FILE_CLASS_UNKNOWN;
                    }
                    if (i == 1) {
                        return NO;
                    }
                    if (i == 2) {
                        return YES;
                    }
                    if (i != 3) {
                        return null;
                    }
                    return LEGACY;
                }

                public static Internal.EnumLiteMap<NestInFileClass> internalGetValueMap() {
                    return internalValueMap;
                }

                public static Internal.EnumVerifier internalGetVerifier() {
                    return NestInFileClassVerifier.INSTANCE;
                }

                static final class NestInFileClassVerifier implements Internal.EnumVerifier {
                    static final Internal.EnumVerifier INSTANCE = new NestInFileClassVerifier();

                    private NestInFileClassVerifier() {
                    }

                    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
                    public boolean isInRange(int i) {
                        return NestInFileClass.forNumber(i) != null;
                    }
                }

                NestInFileClass(int i) {
                    this.value = i;
                }
            }

            public static NestInFileClassFeature parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (NestInFileClassFeature) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
            }

            public static NestInFileClassFeature parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (NestInFileClassFeature) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static NestInFileClassFeature parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (NestInFileClassFeature) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
            }

            public static NestInFileClassFeature parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (NestInFileClassFeature) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static NestInFileClassFeature parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (NestInFileClassFeature) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
            }

            public static NestInFileClassFeature parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (NestInFileClassFeature) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static NestInFileClassFeature parseFrom(InputStream inputStream) throws IOException {
                return (NestInFileClassFeature) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static NestInFileClassFeature parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (NestInFileClassFeature) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static NestInFileClassFeature parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (NestInFileClassFeature) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
            }

            public static NestInFileClassFeature parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (NestInFileClassFeature) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static NestInFileClassFeature parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (NestInFileClassFeature) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
            }

            public static NestInFileClassFeature parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (NestInFileClassFeature) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }

            public static Builder newBuilder() {
                return (Builder) DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(NestInFileClassFeature nestInFileClassFeature) {
                return (Builder) DEFAULT_INSTANCE.createBuilder(nestInFileClassFeature);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<NestInFileClassFeature, Builder> implements NestInFileClassFeatureOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return super.build();
                }

                @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                    return super.buildPartial();
                }

                @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                    return super.clear();
                }

                @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo4918clone() {
                    return super.mo4918clone();
                }

                @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ MessageLite.Builder mo4918clone() {
                    return super.mo4918clone();
                }

                @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ Object mo4918clone() throws CloneNotSupportedException {
                    return super.mo4918clone();
                }

                @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                    return super.getDefaultInstanceForType();
                }

                @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder
                protected /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite abstractMessageLite) {
                    return super.internalMergeFrom((GeneratedMessageLite) abstractMessageLite);
                }

                @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return super.mergeFrom(codedInputStream, extensionRegistryLite);
                }

                @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
                    return super.mergeFrom(bArr, i, i2);
                }

                @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return super.mergeFrom(bArr, i, i2, extensionRegistryLite);
                }

                @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString byteString) throws InvalidProtocolBufferException {
                    return super.mergeFrom(byteString);
                }

                @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return super.mergeFrom(byteString, extensionRegistryLite);
                }

                @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream) throws IOException {
                    return super.mergeFrom(codedInputStream);
                }

                @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return super.mergeFrom(codedInputStream, extensionRegistryLite);
                }

                @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(MessageLite messageLite) {
                    return super.mergeFrom(messageLite);
                }

                @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream inputStream) throws IOException {
                    return super.mergeFrom(inputStream);
                }

                @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    return super.mergeFrom(inputStream, extensionRegistryLite);
                }

                @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] bArr) throws InvalidProtocolBufferException {
                    return super.mergeFrom(bArr);
                }

                @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
                    return super.mergeFrom(bArr, i, i2);
                }

                @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return super.mergeFrom(bArr, i, i2, extensionRegistryLite);
                }

                @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return super.mergeFrom(bArr, extensionRegistryLite);
                }

                private Builder() {
                    super(NestInFileClassFeature.DEFAULT_INSTANCE);
                }
            }

            @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                    case 1:
                        return new NestInFileClassFeature();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0000", null);
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<NestInFileClassFeature> defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            synchronized (NestInFileClassFeature.class) {
                                defaultInstanceBasedParser = PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    PARSER = defaultInstanceBasedParser;
                                }
                                break;
                            }
                        }
                        return defaultInstanceBasedParser;
                    case 6:
                        return (byte) 1;
                    default:
                        throw null;
                }
            }

            static {
                NestInFileClassFeature nestInFileClassFeature = new NestInFileClassFeature();
                DEFAULT_INSTANCE = nestInFileClassFeature;
                GeneratedMessageLite.registerDefaultInstance(NestInFileClassFeature.class, nestInFileClassFeature);
            }

            public static NestInFileClassFeature getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<NestInFileClassFeature> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public boolean hasLegacyClosedEnum() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public boolean getLegacyClosedEnum() {
            return this.legacyClosedEnum_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLegacyClosedEnum(boolean z) {
            this.bitField0_ |= 1;
            this.legacyClosedEnum_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLegacyClosedEnum() {
            this.bitField0_ &= -2;
            this.legacyClosedEnum_ = false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public boolean hasUtf8Validation() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public Utf8Validation getUtf8Validation() {
            Utf8Validation utf8ValidationForNumber = Utf8Validation.forNumber(this.utf8Validation_);
            return utf8ValidationForNumber == null ? Utf8Validation.UTF8_VALIDATION_UNKNOWN : utf8ValidationForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUtf8Validation(Utf8Validation utf8Validation) {
            this.utf8Validation_ = utf8Validation.getNumber();
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUtf8Validation() {
            this.bitField0_ &= -3;
            this.utf8Validation_ = 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public boolean hasLargeEnum() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public boolean getLargeEnum() {
            return this.largeEnum_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLargeEnum(boolean z) {
            this.bitField0_ |= 4;
            this.largeEnum_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLargeEnum() {
            this.bitField0_ &= -5;
            this.largeEnum_ = false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public boolean hasUseOldOuterClassnameDefault() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public boolean getUseOldOuterClassnameDefault() {
            return this.useOldOuterClassnameDefault_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUseOldOuterClassnameDefault(boolean z) {
            this.bitField0_ |= 8;
            this.useOldOuterClassnameDefault_ = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUseOldOuterClassnameDefault() {
            this.bitField0_ &= -9;
            this.useOldOuterClassnameDefault_ = false;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public boolean hasNestInFileClass() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
        public NestInFileClassFeature.NestInFileClass getNestInFileClass() {
            NestInFileClassFeature.NestInFileClass nestInFileClassForNumber = NestInFileClassFeature.NestInFileClass.forNumber(this.nestInFileClass_);
            return nestInFileClassForNumber == null ? NestInFileClassFeature.NestInFileClass.NEST_IN_FILE_CLASS_UNKNOWN : nestInFileClassForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNestInFileClass(NestInFileClassFeature.NestInFileClass nestInFileClass) {
            this.nestInFileClass_ = nestInFileClass.getNumber();
            this.bitField0_ |= 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNestInFileClass() {
            this.bitField0_ &= -17;
            this.nestInFileClass_ = 0;
        }

        public static JavaFeatures parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (JavaFeatures) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static JavaFeatures parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (JavaFeatures) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static JavaFeatures parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (JavaFeatures) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static JavaFeatures parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (JavaFeatures) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static JavaFeatures parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (JavaFeatures) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static JavaFeatures parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (JavaFeatures) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static JavaFeatures parseFrom(InputStream inputStream) throws IOException {
            return (JavaFeatures) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static JavaFeatures parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (JavaFeatures) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static JavaFeatures parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (JavaFeatures) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static JavaFeatures parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (JavaFeatures) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static JavaFeatures parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (JavaFeatures) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static JavaFeatures parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (JavaFeatures) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(JavaFeatures javaFeatures) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(javaFeatures);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<JavaFeatures, Builder> implements JavaFeaturesOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return super.build();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                return super.buildPartial();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                return super.clear();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo4918clone() {
                return super.mo4918clone();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ MessageLite.Builder mo4918clone() {
                return super.mo4918clone();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo4918clone() throws CloneNotSupportedException {
                return super.mo4918clone();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return super.getDefaultInstanceForType();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder
            protected /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite abstractMessageLite) {
                return super.internalMergeFrom((GeneratedMessageLite) abstractMessageLite);
            }

            @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return super.mergeFrom(codedInputStream, extensionRegistryLite);
            }

            @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
                return super.mergeFrom(bArr, i, i2);
            }

            @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return super.mergeFrom(bArr, i, i2, extensionRegistryLite);
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return super.mergeFrom(byteString);
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return super.mergeFrom(byteString, extensionRegistryLite);
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream) throws IOException {
                return super.mergeFrom(codedInputStream);
            }

            @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return super.mergeFrom(codedInputStream, extensionRegistryLite);
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(MessageLite messageLite) {
                return super.mergeFrom(messageLite);
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream inputStream) throws IOException {
                return super.mergeFrom(inputStream);
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return super.mergeFrom(inputStream, extensionRegistryLite);
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return super.mergeFrom(bArr);
            }

            @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
                return super.mergeFrom(bArr, i, i2);
            }

            @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return super.mergeFrom(bArr, i, i2, extensionRegistryLite);
            }

            @Override // com.google.crypto.tink.shaded.protobuf.AbstractMessageLite.Builder, com.google.crypto.tink.shaded.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return super.mergeFrom(bArr, extensionRegistryLite);
            }

            private Builder() {
                super(JavaFeatures.DEFAULT_INSTANCE);
            }

            @Override // com.google.crypto.tink.shaded.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public boolean hasLegacyClosedEnum() {
                return ((JavaFeatures) this.instance).hasLegacyClosedEnum();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public boolean getLegacyClosedEnum() {
                return ((JavaFeatures) this.instance).getLegacyClosedEnum();
            }

            public Builder setLegacyClosedEnum(boolean z) {
                copyOnWrite();
                ((JavaFeatures) this.instance).setLegacyClosedEnum(z);
                return this;
            }

            public Builder clearLegacyClosedEnum() {
                copyOnWrite();
                ((JavaFeatures) this.instance).clearLegacyClosedEnum();
                return this;
            }

            @Override // com.google.crypto.tink.shaded.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public boolean hasUtf8Validation() {
                return ((JavaFeatures) this.instance).hasUtf8Validation();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public Utf8Validation getUtf8Validation() {
                return ((JavaFeatures) this.instance).getUtf8Validation();
            }

            public Builder setUtf8Validation(Utf8Validation utf8Validation) {
                copyOnWrite();
                ((JavaFeatures) this.instance).setUtf8Validation(utf8Validation);
                return this;
            }

            public Builder clearUtf8Validation() {
                copyOnWrite();
                ((JavaFeatures) this.instance).clearUtf8Validation();
                return this;
            }

            @Override // com.google.crypto.tink.shaded.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public boolean hasLargeEnum() {
                return ((JavaFeatures) this.instance).hasLargeEnum();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public boolean getLargeEnum() {
                return ((JavaFeatures) this.instance).getLargeEnum();
            }

            public Builder setLargeEnum(boolean z) {
                copyOnWrite();
                ((JavaFeatures) this.instance).setLargeEnum(z);
                return this;
            }

            public Builder clearLargeEnum() {
                copyOnWrite();
                ((JavaFeatures) this.instance).clearLargeEnum();
                return this;
            }

            @Override // com.google.crypto.tink.shaded.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public boolean hasUseOldOuterClassnameDefault() {
                return ((JavaFeatures) this.instance).hasUseOldOuterClassnameDefault();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public boolean getUseOldOuterClassnameDefault() {
                return ((JavaFeatures) this.instance).getUseOldOuterClassnameDefault();
            }

            public Builder setUseOldOuterClassnameDefault(boolean z) {
                copyOnWrite();
                ((JavaFeatures) this.instance).setUseOldOuterClassnameDefault(z);
                return this;
            }

            public Builder clearUseOldOuterClassnameDefault() {
                copyOnWrite();
                ((JavaFeatures) this.instance).clearUseOldOuterClassnameDefault();
                return this;
            }

            @Override // com.google.crypto.tink.shaded.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public boolean hasNestInFileClass() {
                return ((JavaFeatures) this.instance).hasNestInFileClass();
            }

            @Override // com.google.crypto.tink.shaded.protobuf.JavaFeaturesProto.JavaFeaturesOrBuilder
            public NestInFileClassFeature.NestInFileClass getNestInFileClass() {
                return ((JavaFeatures) this.instance).getNestInFileClass();
            }

            public Builder setNestInFileClass(NestInFileClassFeature.NestInFileClass nestInFileClass) {
                copyOnWrite();
                ((JavaFeatures) this.instance).setNestInFileClass(nestInFileClass);
                return this;
            }

            public Builder clearNestInFileClass() {
                copyOnWrite();
                ((JavaFeatures) this.instance).clearNestInFileClass();
                return this;
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new JavaFeatures();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဇ\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005᠌\u0004", new Object[]{"bitField0_", "legacyClosedEnum_", "utf8Validation_", Utf8Validation.internalGetVerifier(), "largeEnum_", "useOldOuterClassnameDefault_", "nestInFileClass_", NestInFileClassFeature.NestInFileClass.internalGetVerifier()});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<JavaFeatures> defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (JavaFeatures.class) {
                            defaultInstanceBasedParser = PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = defaultInstanceBasedParser;
                            }
                            break;
                        }
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return (byte) 1;
                default:
                    throw null;
            }
        }

        static {
            JavaFeatures javaFeatures = new JavaFeatures();
            DEFAULT_INSTANCE = javaFeatures;
            GeneratedMessageLite.registerDefaultInstance(JavaFeatures.class, javaFeatures);
        }

        public static JavaFeatures getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<JavaFeatures> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.JavaFeaturesProto$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }
}
