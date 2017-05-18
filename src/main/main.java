import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;

public class main {
	
	@SuppressWarnings("null")
	public static void main(String[] args) throws InvalidFormatException, IOException
	{
		
		String texto;
		String txt = new String();
        InputStream modelIn = new FileInputStream( "models/en-token.model" );
		TokenizerModel model = new TokenizerModel( modelIn );
		Tokenizer tokenizer = new TokenizerME(model);
        
        try{
        	
            FileReader fr = new FileReader("example.txt");
            BufferedReader lector = new BufferedReader(fr);
            texto = lector.readLine();
            while(texto != null)
            {
            	txt = txt.concat(texto);
                texto = lector.readLine(); 
            }
            lector.close ();
    		String[] tokens = tokenizer.tokenize(txt);
    		for( String token : tokens )
    		{
    			System.out.println( token );
    		}
            
        }catch(Exception err){
            System.out.println("Error: " + err);
        }

		System.out.println( "\n-----\ndone" );
		
	}

}
