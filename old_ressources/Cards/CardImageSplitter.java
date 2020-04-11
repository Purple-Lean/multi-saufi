import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CardImageSplitter {
	
	/*
	* clubs - kreuz - b
	* diamonds - karo - r
	* hearts - herz - r
	* spades - pik - b
	*/
	
	static char[] types = {'c','d','h','s'};
	
	static int green = new Color(85, 170, 85).getRGB();
	
	static int transparent = new Color(255, 255, 255, 255).getRGB();
	
	public static void main(String[] args) {
		
		System.out.println("Hallo Welt");
		
		split();
	}
	
	public static void cut(BufferedImage img) throws IOException {
		long total = img.getWidth() * img.getHeight();
		List<Integer> rows = new ArrayList<Integer>();
		List<Integer> columns = new ArrayList<Integer>();
		
		boolean column_mode = false;
		boolean row_mode = false;
		int[] row_sums = new int[img.getHeight()];
		for (int x = 0; x < img.getWidth(); x++) {
			int c_greens = 0;
			for (int y = 0; y < img.getHeight(); y++) {
				int rgb = img.getRGB(x, y);
				if (rgb == green) {
					c_greens++;
					row_sums[y]++;
					img.setRGB(x, y, transparent);
				}
			}
			
			if (c_greens * 11 >= img.getHeight() * 10) {
				if (column_mode) {
					columns.add(x - 1);
					column_mode = false;
				}
			}else {
				if (!column_mode) {
					columns.add(x);
					column_mode = true;
				}
			}
		}
		for (int y = 0; y < img.getHeight(); y++) {
			if (row_sums[y] * 11 >= img.getHeight() * 10) {
				if (row_mode) {
					rows.add(y - 1);
					row_mode = false;
				}
			}else {
				if (!row_mode) {
					rows.add(y);
					row_mode = true;
				}
			}
		}
		System.out.println(Arrays.toString(columns.toArray()));
		System.out.println(Arrays.toString(rows.toArray()));
		
		for (int a=0;a<columns.size();a+=2) {	
			for (int b=0;b<rows.size();b+=2) {
				split(img, b/2, a/2, columns.get(a), rows.get(b), columns.get(a+1), rows.get(b+1));
			}
		}
	}
	
	public static void split() {		
		try {
			BufferedImage img = ImageIO.read(new File("cards_600.png"));
			cut(img);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getEncoding(int row, int column) {
		return types[3-row]+""+(((column+12)%13)+2);
	}
	
	public static void split(BufferedImage img, int row, int column, int a_x, int a_y, int b_x, int b_y) throws IOException {
		BufferedImage subimage = img.getSubimage(a_x, a_y, b_x-a_x, b_y-a_y);
		ImageIO.write(subimage, "png", new File("textures/"+getEncoding(row,column)+".png"));
	}
	
}