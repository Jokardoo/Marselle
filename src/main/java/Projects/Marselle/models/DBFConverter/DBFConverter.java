package Projects.Marselle.models.DBFConverter;


import org.jamel.dbf.DbfReader;
import org.jamel.dbf.processor.DbfProcessor;
import org.jamel.dbf.processor.DbfRowMapper;
import org.jamel.dbf.structure.DbfHeader;
import org.jamel.dbf.structure.DbfRow;

import java.io.File;
import java.nio.charset.Charset;

// Класс предназначен для создания файла распила по заданным позициям
public class DBFConverter {
    //test.dbf заменить на название нового файла
    private File file = new File("C:\\Program Files (x86)\\DBF 2Dplace\\test.dbf");

    private DbfReader dbfReader;

    public DBFConverter() {
        this.dbfReader = new DbfReader(file);
    }

//    public void addRows() {
//        DbfHeader dbfHeader = new DbfHeader();
//
//
//        DbfRow dbfRow = new DbfRow(dbfHeader, Charset.defaultCharset(),)
//        }

//    public static void main(String[] args) {
//        DbfReader dbfReader1 = new DbfReader(new File("C:\\Program Files (x86)\\DBF 2Dplace\\test.dbf"));
//        dbfReader1.nextRecord();
//        dbfReader1.
//    }
    }


