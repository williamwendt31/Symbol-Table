
package st;

public class ST {
    private final static int TABLE_SIZE = 11;
    
    chainedEntry[] symbolTable;
    
    ST(){
        symbolTable = new chainedEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            symbolTable[i] = null;
    }
    
    //---returns a hash value given String symbol---
    public int getHash(String symbol){
        int hashValue = symbol.hashCode() % TABLE_SIZE;
        if (hashValue < 0 )
            return (hashValue * -1);
        else 
            return hashValue;
    }
    
    //---inserts new symbol at head of slot in hash table---
    public void insertSymbol(chainedEntry newSymbol){
        int index = getHash(newSymbol.getSymbol());
        if (symbolTable[index] == null){
            symbolTable[index] = newSymbol;//new chainedEntry(symbol, block);
        }
        else{
            newSymbol.setNext(symbolTable[index]); 
            symbolTable[index] = newSymbol;
        }
    }
    
    //---checks to find symbol in current block, if found return null else return new symbol node---
    public chainedEntry findInCurrentScope(String symbol, int block){
        int index = getHash(symbol);
        if (symbolTable[index] != null){
            chainedEntry lastEntry = symbolTable[index];
            while (lastEntry != null){
                if (lastEntry.getSymbol().equals(symbol) && lastEntry.getBlock() == block)//if symbol found return lastENtry
                    return null;//lastEntry;
                lastEntry = lastEntry.getNext();
            }
        }
        return (new chainedEntry(symbol, block));    
    }
    
    //--checks to find symbol in all scopes, if found return that entry, else return null
    public chainedEntry findInAllScopes(String symbol, int block){
        int index = getHash(symbol);
        if (symbolTable[index] != null){
            chainedEntry entry = symbolTable[index];
            while (entry != null){
                if (entry.getSymbol().equals(symbol))
                    return entry;
                entry = entry.getNext();
            }
        }
        return null;
    }
    //---prints out the whole symbol table---
    public void display(){
        chainedEntry symbol = null;
        System.out.println("Symbol Table:");
        for (int i = 0; i < TABLE_SIZE; i++){
            System.out.print("["+i+"]");
            symbol = symbolTable[i];
            if (symbolTable[i] != null){
                do{
                    System.out.print("("+symbol.getSymbol()+":"+symbol.getBlock()+")");
                    symbol = symbol.getNext();
                }
                while (symbol != null);
            }
            System.out.println();
        }
    }
}