
package model;

public class Sessao {
    
    private String numero;
    private String sessionID;
    private String imsi;
    private String imei;
    private String mcc;
    private String mnc;
    private String cellID;
    private String lac;
    private String bearer;
    private String startTime;
    private String endTime;
    private String durationS;
    private String ipAddr;
    private String sipCallID;
    private String codec;
    private String bytesUp;
    private String bytesDown;
    private String lat;
    private String lon;
    private String encryption;

    public Sessao() {
    }

    public Sessao(String numero, String sessionID, String imsi, String imei, String mcc, String mnc, String cellID, String lac, String bearer, String startTime, String endTime, String durationS, String ipAddr, String sipCallID, String codec, String bytesUp, String bytesDown, String lat, String lon, String encryption) {
        this.numero = numero;
        this.sessionID = sessionID;
        this.imsi = imsi;
        this.imei = imei;
        this.mcc = mcc;
        this.mnc = mnc;
        this.cellID = cellID;
        this.lac = lac;
        this.bearer = bearer;
        this.startTime = startTime;
        this.endTime = endTime;
        this.durationS = durationS;
        this.ipAddr = ipAddr;
        this.sipCallID = sipCallID;
        this.codec = codec;
        this.bytesUp = bytesUp;
        this.bytesDown = bytesDown;
        this.lat = lat;
        this.lon = lon;
        this.encryption = encryption;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public String getMnc() {
        return mnc;
    }

    public void setMnc(String mnc) {
        this.mnc = mnc;
    }

    public String getCellID() {
        return cellID;
    }

    public void setCellID(String cellID) {
        this.cellID = cellID;
    }

    public String getLac() {
        return lac;
    }

    public void setLac(String lac) {
        this.lac = lac;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDurationS() {
        return durationS;
    }

    public void setDurationS(String durationS) {
        this.durationS = durationS;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getSipCallID() {
        return sipCallID;
    }

    public void setSipCallID(String sipCallID) {
        this.sipCallID = sipCallID;
    }

    public String getCodec() {
        return codec;
    }

    public void setCodec(String codec) {
        this.codec = codec;
    }

    public String getBytesUp() {
        return bytesUp;
    }

    public void setBytesUp(String bytesUp) {
        this.bytesUp = bytesUp;
    }

    public String getBytesDown() {
        return bytesDown;
    }

    public void setBytesDown(String bytesDown) {
        this.bytesDown = bytesDown;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getEncryption() {
        return encryption;
    }

    public void setEncryption(String encryption) {
        this.encryption = encryption;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sessao{");
        sb.append("numero=").append(numero);
        sb.append(", sessionID=").append(sessionID);
        sb.append(", imsi=").append(imsi);
        sb.append(", imei=").append(imei);
        sb.append(", mcc=").append(mcc);
        sb.append(", mnc=").append(mnc);
        sb.append(", cellID=").append(cellID);
        sb.append(", lac=").append(lac);
        sb.append(", bearer=").append(bearer);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", durationS=").append(durationS);
        sb.append(", ipAddr=").append(ipAddr);
        sb.append(", sipCallID=").append(sipCallID);
        sb.append(", codec=").append(codec);
        sb.append(", bytesUp=").append(bytesUp);
        sb.append(", bytesDown=").append(bytesDown);
        sb.append(", lat=").append(lat);
        sb.append(", lon=").append(lon);
        sb.append(", encryption=").append(encryption);
        sb.append('}');
        return sb.toString();
    }
    
    public Object[] obterDados() {
    return new Object[] {
        numero, sessionID, imsi, imei, mcc, mnc, cellID, lac,
        bearer, startTime, endTime, durationS, ipAddr, sipCallID,
        codec, bytesUp, bytesDown, lat, lon, encryption
    };
}

    // Duas sessões são "a mesma" quando têm o mesmo número (a chave da tabela hash).
    // Só é usado se Sessao for colocada num HashSet ou usada como chave de um HashMap.
    @Override
    public int hashCode() {
        return java.util.Objects.hashCode(numero);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return java.util.Objects.equals(numero, ((Sessao) obj).numero);
    }

}
