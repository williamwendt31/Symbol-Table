
package st;

public class chainedEntry {
    private String symbol;
    private int block;
    private chainedEntry next;
    
    chainedEntry(String symbol, int block){
        this.symbol = symbol;
        this.block = block;
        this.next = null;
    }
    
    public int getBlock(){
        return block;
    }
    
    public void setBlock(int block){
        this.block = block;
    }
    
    public String getSymbol(){
        return symbol;
    }
    
    public chainedEntry getNext(){
        return next;
    }
    
    public void setNext(chainedEntry next){
        this.next = next;
    }

}

