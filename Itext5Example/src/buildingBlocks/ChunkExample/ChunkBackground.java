package buildingBlocks.ChunkExample;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ChunkBackground {
    public static final String DEST =
            "d:/闹着玩的/技能书/Y/itext/虽然是件很麻烦的事,但是我还是决定开始做这件事/example/chapter1/section2/chunk_background.pdf";

    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new ChunkBackground().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        Font f = new Font(FontFamily.TIMES_ROMAN, 25.0f, Font.BOLD, BaseColor.WHITE);
        Chunk c = new Chunk("White text on red background", f);
        c.setBackground(BaseColor.RED);
        Paragraph p = new Paragraph(c);
        document.add(p);
        document.close();
    }
}
