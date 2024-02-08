package Projects.Marselle.models.furnitureGenerator;

import Projects.Marselle.models.DBFConverter.RowFrom2DPlace;
import org.jamel.dbf.DbfReader;
import org.jamel.dbf.processor.DbfProcessor;
import org.jamel.dbf.processor.DbfRowMapper;
import org.jamel.dbf.structure.DbfRow;
import org.jamel.dbf.utils.DbfUtils;

import java.io.File;
import java.util.List;

public class DBFTest {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Цезарь\\Desktop\\Git\\dbf_file.dbf");

        DbfReader dbfReader = new DbfReader(file);
        System.out.println(dbfReader.nextRow().getString("WIDTH"));
    }
}
