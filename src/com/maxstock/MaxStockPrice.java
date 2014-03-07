/**
 * 
 */
package com.maxstock;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author pranav
 *
 */
public class MaxStockPrice {
	
	public static void main(String[] args) {
		Map<String, String> companyDetail = new LinkedHashMap<>();
		String separator = ",";
		String line;
		boolean header = true;
		int len = 0;
		int row = 0;
		int[] maxArr = null;
		String[] companies = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader("E:/eclipse-jee-juno-win32-x86_64/workspace_new/global_logic/src/com/globallogic/test.csv"));
			while((line = br.readLine()) != null) {
				String[] data = line.split(separator);
				if(header) {
					len = data.length;
					companies = new String[len-2];
					maxArr = new int[len-2];
					for(int i=2;i<len;i++) {
						companyDetail.put(data[i], null); 
						companies[i-2] = data[i];
					}
					
				}
				if (!header) {

					String monYear = data[0] + "," + data[1];
					if (row == 1) {
						for (int i = 2; i < len; i++) {
							maxArr[i - 2] = Integer.parseInt(data[i]);
							companyDetail.put(companies[i - 2],monYear);
						}
					} else {
						for(int i = 2; i < len; i++) {
							int val = Integer.parseInt(data[i]);
							if(val > maxArr[i-2]){
								maxArr[i-2] = val;
								companyDetail.put(companies[i-2], monYear);
							}
						}
					}
				}
				if(header)
					header = false;
				row++;
			}
			Set<Entry<String,String>> entrySet = companyDetail.entrySet();
			for(Entry<String, String> enString:entrySet ) {
				System.out.println(enString.getKey() +" : " + enString.getValue());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
}
