cd analyse
del *.class AnalyseurLexical.java AnalyseurSyntaxique.java CodesLexicaux.java
java -jar "D:\Mes Documents\Travail\Programmation\FST Nancy\L3\jflex-1.6.1 tempo\lib\java-cup-11a.jar" -parser AnalyseurSyntaxique -symbols CodesLexicaux Grammaire.cup
java -jar "D:\Mes Documents\Travail\Programmation\FST Nancy\L3\jflex-1.6.1 tempo\lib\jflex-1.6.1.jar" AnalyseurLexical.jflex
cd ..
ls
javac -cp "D:\Mes Documents\Travail\Programmation\FST Nancy\L3\toucantempo";"D:\Mes Documents\Travail\Programmation\FST Nancy\L3\jflex-1.6.1 tempo\lib\java-cup-11a.jar" .\analyse\*.java
pause