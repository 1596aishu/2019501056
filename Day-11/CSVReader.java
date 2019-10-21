/**
 * Given a CSV file, we will read the data from the CSV file and parses each
 * line of the file. See the operations that are performed after reading the
 * file.
 * 
 * @author Siva Sankar
 * @author Nemnous
 */

import java.util.Arrays;
import java.util.ArrayList;
import java.*;
public class CSVReader {
    String[] dataFrame;

    /**
     * This function is used to read the given csv File This uses functions from the
     * ReadCSVFile class
     * 
     * @param fileName - name of the given csv file
     */
    public void readCSV(String fileName) {
        dataFrame = ReadCSVFile.readFile(fileName);
    }

    /**
     * The number of rows in the given data frame. Note: This shouldn't include 
     * the coloumn labels.
     * 
     * @return -1 if the Data set is empty
     */
    public int rowCount() {
        // TODO
        // Your code goes here....
        if(dataFrame.length != 0){
                // System.out.println(dataFrame.length - 1);
                return dataFrame.length - 1;
            }
        return -1;
    }

    /**
     * This method returns the count of coloumns in a data Frame.
     * @return the count of columns in the dataset and -1 otherwise.
     */
    public int fieldCount() {
        // TODO
        // Your code goes here....
        if(dataFrame.length != 0){
            String [] lables = dataFrame[0].split(",");
            return lables.length;
        }
        return -1;
    }

    /**
     * This method returns the name of the column based on the index 
     * passed as a parameter
     * 
     * @param index index of the coloumn starting from 1.
     * @return the column name based on the index and null otherwise.
     */
    public String getFieldName(int index) {
        // TODO
        // Your code goes here....
        if(dataFrame.length != 0){
            String [] lables = dataFrame[0].split(",");
            if(index > 0 && index <= lables.length){
                return lables[index-1];
            }
            return null;
        }
        return null;
    }


    /**
     * This method returns the row (array of values) based on the parameter 
     * passed to the method.
     * 
     * @param rowNumber given the Row of the row indexing from 1. Exclude the column
     * header row
     * 
     * @return the string array containing the contents of the entire row.
     */
    public String[] getRow(int rowNumber) {
        // TODO
        // Your code goes here....
        if(dataFrame.length != 0){
            if(rowNumber >0 && rowNumber < dataFrame.length){
                // System.out.println(dataFrame[rowNumber].split(","));
                return dataFrame[rowNumber].split(",");
            }
            return null;
        }
        return null;
    }

    /**
     * This method returns the rows (String array) based on fromIndex and toIndex.
     * The fromIndex and toIndex should be in the range of the dataset lengths.
     * 
     * @param fromIndex given from index
     * @param toIndex   given to index
     * @return String array containing the rows starting from the fromindex to the
     *         toindex. Append the entire row to the string array comma separated.
     */
    public String[] getRows(int fromIndex, int toIndex) {
        // TODO
        // Your code goes here....
        if(dataFrame != null && fromIndex < toIndex){

            ArrayList<String> send = new ArrayList<String>();
            if(!(fromIndex<1 || toIndex<1) && !(fromIndex>=dataFrame.length || toIndex>=dataFrame.length)){
                for(int i = fromIndex;i<toIndex;i++){
                    send.add(dataFrame[i]);
                }
                String [] rows = send.toArray(new String[send.size()]);

                return rows;
            }
            return null;
        }
        return null;
    }

    /**
     * This method returns the column values based on particular column index.
     * 
     * @param index index of the column
     * @return all the values of the column as a string array
     */
    public String[] getColumnValues(int index) {
        // TODO
        // Your code goes here....
        if(dataFrame != null){
            if(dataFrame.length != 0){
                ArrayList<String> values = new ArrayList<String>();
                for(int j = 1;j<dataFrame.length;j++){
                    String [] temp = dataFrame[j].split(",");
                    values.add(temp[index]);
                }
                String [] colVal = values.toArray(new String[values.size()]);
                return colVal;
            }
        }


        return null;
    }
    
}
