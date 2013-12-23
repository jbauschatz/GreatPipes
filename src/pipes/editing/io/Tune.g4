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
measure : (START_REPEAT WS)? (TimeSignature)? WS? (melodyElement WS)* (END_REPEAT WS)? '|' ;
TimeSignature : '[' NUMBER '/' NUMBER ']' ;
melodyElement : EMBELLISHMENT | note | TIE ;
note : NOTENAME '-' NUMBER '.'* ;
NOTENAME : 'g' | 'a' | 'b' | 'c' | 'd' | 'e' | 'f' | 'G' | 'A' ;
NUMBER : ('0'..'9')+ ;
TIE : '-' ;
START_REPEAT : '|:' ;
END_REPEAT : ':|' ;
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