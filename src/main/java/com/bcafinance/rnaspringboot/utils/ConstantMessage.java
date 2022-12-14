package com.bcafinance.rnaspringboot.utils;

public class ConstantMessage {

    /*
    Memperbolehkan nilai numerik dari 0 hingga 9.
    Memperbolehkan Huruf besar dan huruf kecil dari a sampai z.
    Yang diperbolehkan hanya garis bawah “_”, tanda hubung “-“ dan titik “.”
    Titik tidak diperbolehkan di awal dan akhir local part (sebelum tanda @).
    Titik berurutan tidak diperbolehkan.
    Local part, maksimal 64 karakter.
     */
//    public final static String REGEX_EMAIL_STRICT = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";

    /*REGEX*/
    public final static String REGEX_PHONE = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$";
    /*
    * Tidak memperbolehkan tanda | (pipa) dan ' (petik 1)
    */
    public final static String REGEX_EMAIL_STANDARD_RFC5322  = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    public final static String REGEX_DATE_YYYYMMDD  = "^([0-9][0-9])?[0-9][0-9]-(0[0-9]||1[0-2])-([0-2][0-9]||3[0-1])$";
    public final static String REGEX_DATE_DDMMYYYY  = "^([0-2][0-9]||3[0-1])-(0[0-9]||1[0-2])-([0-9][0-9])?[0-9][0-9]$";

    /*Global*/

    public final static String CONTENT_TYPE_CSV = "text/csv";
    public final static String SUCCESS_SAVE = "DATA BERHASIL DIBUAT";
    public final static String SUCCESS_FIND_BY = "OK";

    public final static String ERROR_UPLOAD_CSV = "UPLOAD FILE GAGAL ";
    public final static String ERROR_NOT_CSV_FILE = "FORMAT FILE HARUS CSV ";
    public final static String SUCCESS_SEND_EMAIL = "SILAHKAN CEK EMAIL YANG TELAH ANDA DAFTARKAN";
    public final static String WARNING_NOT_FOUND = "DATA TIDAK DITEMUKAN";
    public final static String WARNING_DATA_EMPTY = "DATA TIDAK ADA";

    public final static String ERROR_DATA_INVALID = "DATA TIDAK VALID";
    public final static String ERROR_INTERNAL_SERVER = "INTERNAL SERVER ERROR";
    public final static String ERROR_MAIL_FORM_JSON = "Malformed JSON request";
    public final static String ERROR_EMAIL_FORMAT_INVALID = "FORMAT EMAIL TIDAK SESUAI (Nomor/Karakter@Nomor/Karakter)";

    public final static String SUCCESS_TRANSFER_WALLET = "TRANSFER WALLET BERHASIL";
    public final static String WARNING_REGION_NAME_LENGTH = "NAMA REGION MEAKSIMAL 50";
    public final static String ERROR_PHONE_NUMBER_FORMAT_INVALID = "FORMAT NOMOR HANDPHONE TIDAK SESUAI (+628XX-)";
    public final static String ERROR_DATE_FORMAT_YYYYMMDD = "FORMAT TANGGAL TIDAK SESUAI (YYYY-mm-dd)";

    public final static String ERROR_UNEXPECTED = "UNEXPECTED ERROR";
    public final static String ERROR_UNPROCCESSABLE = "Validation error. Check 'errors' field for details.";

    public final static String ERROR_NO_CONTENT = "PERMINTAAN TIDAK DAPAT DIPROSES";
    public final static String WELCOME_MESSAGE = "This is Springboot BootCamp BCAF BATCH 1";
    public final static String TAKE_TOUR = "Ready To Start";

    /*Customer*/
    public final static String SUCCESS = "";
    public final static String ERROR = "";
    public final static String WARNING_EMAIL_EXIST = "EMAIL SUDAH TERDAFTAR";

    public final static String WARNING_EMAIL_MANDATORY = "EMAIL TIDAK VALID";

    public final static String WARNING_REKENING_ASAL = "REKENING ASAL KOSONG";

    public final static String WARNING_NAME_MAX_LENGTH = "VALUE LEBIH DARI BATAS";

    public final static String WARNING_REKENING_PENERIMA = "REKENING ASAL KOSONG";

    public final static String WARNING_NOMINAL_REQUIRED = "NOMINAL KOSONG";

    public final static String WARNING_SALDO_LIMIT = "SALDO TIDAK MENCUKUPI";

    public final static String WARNING_FAIL_TRANSFER = "TRANSFER GAGAL";
    public final static String WARNING_USERNAME_MENDATORY = "USERNAME TIDAK VALID";
    public final static String WARNING_KODEGROUP_MANDATORY = "KODE GROUP TIDAK VALID";
    public final static String WARNING_WILAYAHREGION_MANDATORY = "WILAYAH REGION TIDAK VALID";

    public final static String WARNING_FULLNAME_MANDATORY = "NAMA AWAL WAJIB DIISI";
    public final static String WARNING_PHONENUMBER_MANDATORY = "EMAIL TIDAK VALID";
    public final static String WARNING_CUSTOMER_NOT_FOUND = "CUSTOMER BELUM TERDAFTAR";

    public final static String WARNING_SUPPLIER_NOT_FOUND = "SUPPLIER BELUM TERDAFTAR";

    /*Products*/
    public final static String WARNING_PRODUCT_NOT_FOUND = "PRODUK TIDAK DITEMUKAN";
    public final static String WARNING_SUPPLIER_DATA_NOT_FOUND = "SUPPLIER TIDAK DITEMUKAN";

    public final static String WARNING_FOOD_DATA_NOT_FOUND = "FOOD TIDAK DITEMUKAN";

    public final static String WARNING_REGION_DATA_NOT_FOUND = "REGION TIDAK DITEMUKAN";
    public final static String WARNING_DATA_NOT_FOUND = "DATA TIDAK DITEMUKAN";
    public final static String WARNING_PRODUCT_PRICE_SOP = "HARGA TIDAK BOLEH 1/2 ATAU 3 KALI DARI HARGA SEBELUMNYA";
    public final static String ERROR_TIDAK_BOLEH_KOSONG_VAR_1 = "DATA VAR 1 TIDAK BOLEH KOSONG";
    public final static String ERROR_TIDAK_BOLEH_KOSONG_VAR_2 = "DATA VAR 2 TIDAK BOLEH KOSONG";

    public final static String ERROR_TIDAK_BOLEH_KOSONG_VAR_3 = "DATA VAR 3 TIDAK BOLEH KOSONG";

    /*Employee*/

}
