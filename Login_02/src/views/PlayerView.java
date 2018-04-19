package views;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;


public class PlayerView {


	public void runView(ResultSet rs) throws IOException {
		// instantiate vector objects to hold column/row data for JTable
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		Vector<String> column = new Vector<String>();
		try {
			ResultSetMetaData metaData = rs.getMetaData();
			int columns = metaData.getColumnCount();

			// get column names from table
			String cols = "";

			for (int i = 1; i <= columns; i++) {
				cols = metaData.getColumnName(i);
				column.add(cols);
			}
			// get row data from table!

			while (rs.next()) {
				Vector<Object> row = new Vector<Object>(columns);

				for (int i = 1; i <= columns; i++) {
				if(i == columns) {
				InputStream is =	rs.getBinaryStream(columns);
				OutputStream os = new FileOutputStream(new File("photo.jpg"));
				byte[] content = new byte[1024];
				int size = 0;
				while((size = is.read(content))!=-1 ){
					os.write(content, 0, size);
				}
				os.close();
				is.close();
				Image image = new Image("file:photo.jpg", 100,150, true, true);
				ImageView imageView = new ImageView(image);
				imageView.setFitWidth(100);
				imageView.setFitHeight(150);
				imageView.setPreserveRatio(true);
				BorderPane layout = new BorderPane();
				layout.setCenter(imageView);
				BorderPane.setAlignment(imageView, Pos.TOP_LEFT);
				row.addElement(imageView);
//					Object object = rs.getObject(i);
//					FileInputStream fis = (FileInputStream)object;
//					Image	profileImage = new Image(fis);
//					row.addElement(profileImage);
				}else {
					row.addElement(rs.getObject(i));
				}
				}
				
				data.addElement(row);
			}

			DefaultTableModel model = new DefaultTableModel(data, column);

			JTable table = new JTable(model);
			JFrame frame = new JFrame("Player View");
			frame.setSize(700, 200);
			frame.add(new JScrollPane(table));
			frame.setDefaultCloseOperation(0);
			frame.pack();
			frame.setVisible(true);

			rs.close(); //close ResultSet instance 
		} catch (SQLException e) { e.printStackTrace(); }
	}

}
