package toucan.outils;

import java.net.URI;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;

public class JavaSource extends SimpleJavaFileObject {
/**
 * A file object used to represent source coming from a string.
 */
           
    /**
      * The source code of this "file".
      */
    protected final String code;

    /**
     * Constructs a new JavaSourceFromString.
     * @param name the name of the compilation unit represented by this file object
     * @param code the source code for the compilation unit represented by this file object
     */ 
    public JavaSource(String name, String code) {
        super(URI.create("string:///" + name.replace('.','/') + JavaFileObject.Kind.SOURCE.extension), JavaFileObject.Kind.SOURCE);
        this.code = code;
    }
 
    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return code;
    }
    
}
