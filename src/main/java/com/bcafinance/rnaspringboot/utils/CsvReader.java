package com.bcafinance.rnaspringboot.utils;


import com.bcafinance.rnaspringboot.models.Student;
import com.bcafinance.rnaspringboot.models.Transaction;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public static boolean isCsv(MultipartFile multipartFile)
    {
        if(!ConstantMessage.CONTENT_TYPE_CSV.equals(multipartFile.getContentType()))
        {
            return false;
        }
        return true;
    }

    public static List<Student> csvStudentData(InputStream inputStream) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        CSVParser csvParser = new CSVParser(bufferedReader,
                CSVFormat.DEFAULT.withFirstRecordAsHeader().
                        withIgnoreHeaderCase().
                        withTrim()
        );
        List<Student> lsStudents = new ArrayList<Student>();
        try {

            Iterable<CSVRecord> iterRecords = csvParser.getRecords();

            for (CSVRecord record : iterRecords) {
                Student student = new Student();
                student.setNim(record.get("Nim"));
                student.setFullName(record.get("FullName"));
                student.setBirthDate(LocalDate.parse(record.get("BirthDate")));
                student.setAddress(record.get("Address"));
                student.setGender(record.get("Gender"));

                lsStudents.add(student);
            }

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        } finally {

            if (!csvParser.isClosed()) {
                csvParser.close();
            }
            return lsStudents;
        }
    }

    public static List<Transaction> csvTransactionData(InputStream inputStream) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        CSVParser csvParser = new CSVParser(bufferedReader,
                CSVFormat.DEFAULT.withFirstRecordAsHeader().
                        withIgnoreHeaderCase().
                        withTrim()
        );
        List<Transaction> lsTransaction = new ArrayList<Transaction>();
        try {

            Iterable<CSVRecord> iterRecords = csvParser.getRecords();

            for (CSVRecord record : iterRecords) {
                Transaction transaction = new Transaction();
                transaction.setNameCustomer(record.get("nameCustomer"));
                transaction.setAgeCustomer(Integer.parseInt(record.get("age")));
                transaction.setAddressCustomer(record.get("address"));
                transaction.setTotalItem(Integer.parseInt(record.get("totalItem")));
                transaction.setCost(Double.parseDouble(record.get("cost")));
                transaction.setCashback(Double.parseDouble(record.get("cashback")));
                transaction.setBillDate(LocalDate.parse(record.get("billDate")));
                transaction.setPayDate(LocalDate.parse(record.get("payDate")));

                lsTransaction.add(transaction);
            }

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        } finally {

            if (!csvParser.isClosed()) {
                csvParser.close();
            }
            return lsTransaction;
        }
    }
}