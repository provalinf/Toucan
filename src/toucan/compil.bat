cd analyse
del *.class AnalyseurLexical.java AnalyseurSyntaxique.java CodesLexicaux.java
java -jar "C:\Users\Cyril\Desktop\toucan_final\jflex-1.6.1\lib\java-cup-11a.jar" -parser AnalyseurSyntaxique -symbols CodesLexicaux Grammaire.cup
java -jar "C:\Users\Cyril\Desktop\toucan_final\jflex-1.6.1\lib\jflex-1.6.1.jar" AnalyseurLexical.jflex
cd ..
ls
javac -cp "C:\Users\Cyril\Desktop\toucan_final\Toucan\src";"C:\Users\Cyril\Desktop\toucan_final\jflex-1.6.1\lib\java-cup-11a.jar" .\analyse\*.java
pause