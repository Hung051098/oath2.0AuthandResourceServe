1: Tạo keytooll
    File .jks:
        keytool -genkeypair -alias jwt -keyalg RSA -keystore jwthung.jks -keypass password -storepass password
    Tạo public key:
        keytool -list -rfc --keystore jwthung.jks | openssl x509 -inform pem -pubkey
