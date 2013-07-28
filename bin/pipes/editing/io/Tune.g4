grammar Tune;
@header {
package pipes.editing.io;
}
tune    : (line LINE)* line ;
line    : measure+  ;
measure : (TimeSignature)? WS? (melodyElement WS)* WS? '|' ;
TimeSignature : '[' NUMBER '/' NUMBER ']' ;
melodyElement : EMBELLISHMENT | note ;
note : NOTENAME '-' NUMBER '.'* ;
NOTENAME : 'g' | 'a' | 'b' | 'c' | 'd' | 'e' | 'f' | 'G' | 'A' ;
NUMBER : ('0'..'9')+ ;
EMBELLISHMENT :
	'\'A' 
	| '\'G' 
	| '\'d' 
	| '\'e' 
	| 'dbl'
	| 'thrw'
	| 'birl'
	| 'grip'
	| 'taor'
	| 'crun' ;
WS : ( '\t' | ' ' )+ ;
LINE : '\r'? '\n' ;