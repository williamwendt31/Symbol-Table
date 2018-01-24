
package st;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class driverCompiler {
    
    public static void main(String[] args) throws Exception{
        ST myTable = new ST();
        try (Scanner inputFile = new Scanner(new File("sample.txt"))) {
            Stack<Integer> activeBlock = new Stack<>();
            int blockNum = 0;
            while (inputFile.hasNext()){
                String token = inputFile.next();
                if (token.equals("{")){
                    blockNum += 1;
                    activeBlock.push(blockNum);
                }
                else if (token.equals("}"))
                    activeBlock.pop();
                else{
                    chainedEntry current = myTable.findInCurrentScope(token, activeBlock.peek());
                    if (current == null){
                        myTable.insertSymbol(token, activeBlock.peek());
                        current = myTable.findInAllScopes(token, activeBlock.peek());
                    }
                }
            }
            myTable.display();
            inputFile.close();
        }
        catch(Exception e){
            System.out.println("Error occurred");
        }
    }
}

