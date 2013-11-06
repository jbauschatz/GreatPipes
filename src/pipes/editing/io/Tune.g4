grammar Tune;
@header {
package pipes.editing.io;
}
tune :	name LINE 
		author LINE
		type LINE 
		(line LINE)* line ;
name : TEXT ;
author : TEXT ;
type : TEXT ;
TEXT : '[' ('A'..'Z'|'a'..'z'|'0'..'9'|' '|','|'.')* ']' ;
line    : measure+  ;
measure : (TimeSignature)? WS? (melodyElement WS)* WS? '|' ;
TimeSignature : '[' NUMBER '/' NUMBER ']' ;
melodyElement : EMBELLISHMENT | note | TIE ;
note : NOTENAME '-' NUMBER '.'* ;
NOTENAME : 'g' | 'a' | 'b' | 'c' | 'd' | 'e' | 'f' | 'G' | 'A' ;
NUMBER : ('0'..'9')+ ;
TIE : '-' ;
EMBELLISHMENT :
	'\'A' 
	| '\'G' 
	| '\'d' 
	| '\'e' 
	| 'dbl'
	| 'thrw'
	| 'str'
	| 'birl'
	| 'grip'
	| 'taor'
	| 'crun' ;
WS : ( '\t' | ' ' )+ ;
LINE : '\r'? '\n' ;