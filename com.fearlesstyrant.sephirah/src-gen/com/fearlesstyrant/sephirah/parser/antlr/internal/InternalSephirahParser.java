package com.fearlesstyrant.sephirah.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.fearlesstyrant.sephirah.services.SephirahGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSephirahParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_ESCAPED_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'SephirahDoc'", "'import'", "';'", "'def'", "'('", "','", "')'", "'='", "'var'", "'+'", "'-'", "'*'", "'/'", "'^'", "'pi'", "'G'", "'phi'", "'gamma'", "'e'", "'.'"
    };
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int RULE_ESCAPED_ID=5;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalSephirahParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSephirahParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSephirahParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSephirah.g"; }



     	private SephirahGrammarAccess grammarAccess;

        public InternalSephirahParser(TokenStream input, SephirahGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "FormulaModel";
       	}

       	@Override
       	protected SephirahGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleFormulaModel"
    // InternalSephirah.g:64:1: entryRuleFormulaModel returns [EObject current=null] : iv_ruleFormulaModel= ruleFormulaModel EOF ;
    public final EObject entryRuleFormulaModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormulaModel = null;


        try {
            // InternalSephirah.g:64:53: (iv_ruleFormulaModel= ruleFormulaModel EOF )
            // InternalSephirah.g:65:2: iv_ruleFormulaModel= ruleFormulaModel EOF
            {
             newCompositeNode(grammarAccess.getFormulaModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFormulaModel=ruleFormulaModel();

            state._fsp--;

             current =iv_ruleFormulaModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFormulaModel"


    // $ANTLR start "ruleFormulaModel"
    // InternalSephirah.g:71:1: ruleFormulaModel returns [EObject current=null] : ( ( (lv_name_0_0= ruleDocName ) )? ( (lv_imports_1_0= ruleImport ) )* ( ( (lv_methodDefs_2_0= ruleDefinition ) ) | ( (lv_variables_3_0= ruleVariableAssignment ) ) | ( (lv_values_4_0= ruleEvaluation ) ) )* ) ;
    public final EObject ruleFormulaModel() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;

        EObject lv_imports_1_0 = null;

        EObject lv_methodDefs_2_0 = null;

        EObject lv_variables_3_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:77:2: ( ( ( (lv_name_0_0= ruleDocName ) )? ( (lv_imports_1_0= ruleImport ) )* ( ( (lv_methodDefs_2_0= ruleDefinition ) ) | ( (lv_variables_3_0= ruleVariableAssignment ) ) | ( (lv_values_4_0= ruleEvaluation ) ) )* ) )
            // InternalSephirah.g:78:2: ( ( (lv_name_0_0= ruleDocName ) )? ( (lv_imports_1_0= ruleImport ) )* ( ( (lv_methodDefs_2_0= ruleDefinition ) ) | ( (lv_variables_3_0= ruleVariableAssignment ) ) | ( (lv_values_4_0= ruleEvaluation ) ) )* )
            {
            // InternalSephirah.g:78:2: ( ( (lv_name_0_0= ruleDocName ) )? ( (lv_imports_1_0= ruleImport ) )* ( ( (lv_methodDefs_2_0= ruleDefinition ) ) | ( (lv_variables_3_0= ruleVariableAssignment ) ) | ( (lv_values_4_0= ruleEvaluation ) ) )* )
            // InternalSephirah.g:79:3: ( (lv_name_0_0= ruleDocName ) )? ( (lv_imports_1_0= ruleImport ) )* ( ( (lv_methodDefs_2_0= ruleDefinition ) ) | ( (lv_variables_3_0= ruleVariableAssignment ) ) | ( (lv_values_4_0= ruleEvaluation ) ) )*
            {
            // InternalSephirah.g:79:3: ( (lv_name_0_0= ruleDocName ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalSephirah.g:80:4: (lv_name_0_0= ruleDocName )
                    {
                    // InternalSephirah.g:80:4: (lv_name_0_0= ruleDocName )
                    // InternalSephirah.g:81:5: lv_name_0_0= ruleDocName
                    {

                    					newCompositeNode(grammarAccess.getFormulaModelAccess().getNameDocNameParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_3);
                    lv_name_0_0=ruleDocName();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getFormulaModelRule());
                    					}
                    					set(
                    						current,
                    						"name",
                    						lv_name_0_0,
                    						"com.fearlesstyrant.sephirah.Sephirah.DocName");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalSephirah.g:98:3: ( (lv_imports_1_0= ruleImport ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalSephirah.g:99:4: (lv_imports_1_0= ruleImport )
            	    {
            	    // InternalSephirah.g:99:4: (lv_imports_1_0= ruleImport )
            	    // InternalSephirah.g:100:5: lv_imports_1_0= ruleImport
            	    {

            	    					newCompositeNode(grammarAccess.getFormulaModelAccess().getImportsImportParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_imports_1_0=ruleImport();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getFormulaModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"imports",
            	    						lv_imports_1_0,
            	    						"com.fearlesstyrant.sephirah.Sephirah.Import");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalSephirah.g:117:3: ( ( (lv_methodDefs_2_0= ruleDefinition ) ) | ( (lv_variables_3_0= ruleVariableAssignment ) ) | ( (lv_values_4_0= ruleEvaluation ) ) )*
            loop3:
            do {
                int alt3=4;
                switch ( input.LA(1) ) {
                case 15:
                    {
                    alt3=1;
                    }
                    break;
                case 20:
                    {
                    alt3=2;
                    }
                    break;
                case RULE_ID:
                case RULE_ESCAPED_ID:
                case RULE_INT:
                case 16:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                    {
                    alt3=3;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // InternalSephirah.g:118:4: ( (lv_methodDefs_2_0= ruleDefinition ) )
            	    {
            	    // InternalSephirah.g:118:4: ( (lv_methodDefs_2_0= ruleDefinition ) )
            	    // InternalSephirah.g:119:5: (lv_methodDefs_2_0= ruleDefinition )
            	    {
            	    // InternalSephirah.g:119:5: (lv_methodDefs_2_0= ruleDefinition )
            	    // InternalSephirah.g:120:6: lv_methodDefs_2_0= ruleDefinition
            	    {

            	    						newCompositeNode(grammarAccess.getFormulaModelAccess().getMethodDefsDefinitionParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_4);
            	    lv_methodDefs_2_0=ruleDefinition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getFormulaModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"methodDefs",
            	    							lv_methodDefs_2_0,
            	    							"com.fearlesstyrant.sephirah.Sephirah.Definition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSephirah.g:138:4: ( (lv_variables_3_0= ruleVariableAssignment ) )
            	    {
            	    // InternalSephirah.g:138:4: ( (lv_variables_3_0= ruleVariableAssignment ) )
            	    // InternalSephirah.g:139:5: (lv_variables_3_0= ruleVariableAssignment )
            	    {
            	    // InternalSephirah.g:139:5: (lv_variables_3_0= ruleVariableAssignment )
            	    // InternalSephirah.g:140:6: lv_variables_3_0= ruleVariableAssignment
            	    {

            	    						newCompositeNode(grammarAccess.getFormulaModelAccess().getVariablesVariableAssignmentParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_4);
            	    lv_variables_3_0=ruleVariableAssignment();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getFormulaModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"variables",
            	    							lv_variables_3_0,
            	    							"com.fearlesstyrant.sephirah.Sephirah.VariableAssignment");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalSephirah.g:158:4: ( (lv_values_4_0= ruleEvaluation ) )
            	    {
            	    // InternalSephirah.g:158:4: ( (lv_values_4_0= ruleEvaluation ) )
            	    // InternalSephirah.g:159:5: (lv_values_4_0= ruleEvaluation )
            	    {
            	    // InternalSephirah.g:159:5: (lv_values_4_0= ruleEvaluation )
            	    // InternalSephirah.g:160:6: lv_values_4_0= ruleEvaluation
            	    {

            	    						newCompositeNode(grammarAccess.getFormulaModelAccess().getValuesEvaluationParserRuleCall_2_2_0());
            	    					
            	    pushFollow(FOLLOW_4);
            	    lv_values_4_0=ruleEvaluation();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getFormulaModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"values",
            	    							lv_values_4_0,
            	    							"com.fearlesstyrant.sephirah.Sephirah.Evaluation");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFormulaModel"


    // $ANTLR start "entryRuleDocName"
    // InternalSephirah.g:182:1: entryRuleDocName returns [EObject current=null] : iv_ruleDocName= ruleDocName EOF ;
    public final EObject entryRuleDocName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocName = null;


        try {
            // InternalSephirah.g:182:48: (iv_ruleDocName= ruleDocName EOF )
            // InternalSephirah.g:183:2: iv_ruleDocName= ruleDocName EOF
            {
             newCompositeNode(grammarAccess.getDocNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDocName=ruleDocName();

            state._fsp--;

             current =iv_ruleDocName; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDocName"


    // $ANTLR start "ruleDocName"
    // InternalSephirah.g:189:1: ruleDocName returns [EObject current=null] : (otherlv_0= 'SephirahDoc' ( (lv_name_1_0= ruleQualifiedName ) ) ) ;
    public final EObject ruleDocName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:195:2: ( (otherlv_0= 'SephirahDoc' ( (lv_name_1_0= ruleQualifiedName ) ) ) )
            // InternalSephirah.g:196:2: (otherlv_0= 'SephirahDoc' ( (lv_name_1_0= ruleQualifiedName ) ) )
            {
            // InternalSephirah.g:196:2: (otherlv_0= 'SephirahDoc' ( (lv_name_1_0= ruleQualifiedName ) ) )
            // InternalSephirah.g:197:3: otherlv_0= 'SephirahDoc' ( (lv_name_1_0= ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getDocNameAccess().getSephirahDocKeyword_0());
            		
            // InternalSephirah.g:201:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalSephirah.g:202:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalSephirah.g:202:4: (lv_name_1_0= ruleQualifiedName )
            // InternalSephirah.g:203:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getDocNameAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDocNameRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.fearlesstyrant.sephirah.Sephirah.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDocName"


    // $ANTLR start "entryRuleImport"
    // InternalSephirah.g:224:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalSephirah.g:224:47: (iv_ruleImport= ruleImport EOF )
            // InternalSephirah.g:225:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalSephirah.g:231:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= ';' ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:237:2: ( (otherlv_0= 'import' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= ';' ) )
            // InternalSephirah.g:238:2: (otherlv_0= 'import' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= ';' )
            {
            // InternalSephirah.g:238:2: (otherlv_0= 'import' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= ';' )
            // InternalSephirah.g:239:3: otherlv_0= 'import' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalSephirah.g:243:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalSephirah.g:244:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalSephirah.g:244:4: (lv_name_1_0= ruleQualifiedName )
            // InternalSephirah.g:245:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getImportAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_6);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getImportRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.fearlesstyrant.sephirah.Sephirah.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getImportAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleDefinition"
    // InternalSephirah.g:270:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // InternalSephirah.g:270:51: (iv_ruleDefinition= ruleDefinition EOF )
            // InternalSephirah.g:271:2: iv_ruleDefinition= ruleDefinition EOF
            {
             newCompositeNode(grammarAccess.getDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDefinition=ruleDefinition();

            state._fsp--;

             current =iv_ruleDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefinition"


    // $ANTLR start "ruleDefinition"
    // InternalSephirah.g:277:1: ruleDefinition returns [EObject current=null] : (otherlv_0= 'def' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )* )? otherlv_6= ')' otherlv_7= '=' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';' ) ;
    public final EObject ruleDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_args_3_0 = null;

        EObject lv_args_5_0 = null;

        EObject lv_expr_8_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:283:2: ( (otherlv_0= 'def' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )* )? otherlv_6= ')' otherlv_7= '=' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
            // InternalSephirah.g:284:2: (otherlv_0= 'def' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )* )? otherlv_6= ')' otherlv_7= '=' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';' )
            {
            // InternalSephirah.g:284:2: (otherlv_0= 'def' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )* )? otherlv_6= ')' otherlv_7= '=' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';' )
            // InternalSephirah.g:285:3: otherlv_0= 'def' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )* )? otherlv_6= ')' otherlv_7= '=' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getDefinitionAccess().getDefKeyword_0());
            		
            // InternalSephirah.g:289:3: ( (lv_name_1_0= ruleValidID ) )
            // InternalSephirah.g:290:4: (lv_name_1_0= ruleValidID )
            {
            // InternalSephirah.g:290:4: (lv_name_1_0= ruleValidID )
            // InternalSephirah.g:291:5: lv_name_1_0= ruleValidID
            {

            					newCompositeNode(grammarAccess.getDefinitionAccess().getNameValidIDParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_7);
            lv_name_1_0=ruleValidID();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDefinitionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.fearlesstyrant.sephirah.Sephirah.ValidID");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_2());
            		
            // InternalSephirah.g:312:3: ( ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=RULE_ID && LA5_0<=RULE_ESCAPED_ID)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalSephirah.g:313:4: ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )*
                    {
                    // InternalSephirah.g:313:4: ( (lv_args_3_0= ruleDefinitionVariable ) )
                    // InternalSephirah.g:314:5: (lv_args_3_0= ruleDefinitionVariable )
                    {
                    // InternalSephirah.g:314:5: (lv_args_3_0= ruleDefinitionVariable )
                    // InternalSephirah.g:315:6: lv_args_3_0= ruleDefinitionVariable
                    {

                    						newCompositeNode(grammarAccess.getDefinitionAccess().getArgsDefinitionVariableParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_args_3_0=ruleDefinitionVariable();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDefinitionRule());
                    						}
                    						add(
                    							current,
                    							"args",
                    							lv_args_3_0,
                    							"com.fearlesstyrant.sephirah.Sephirah.DefinitionVariable");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSephirah.g:332:4: (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==17) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalSephirah.g:333:5: otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) )
                    	    {
                    	    otherlv_4=(Token)match(input,17,FOLLOW_5); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getDefinitionAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalSephirah.g:337:5: ( (lv_args_5_0= ruleDefinitionVariable ) )
                    	    // InternalSephirah.g:338:6: (lv_args_5_0= ruleDefinitionVariable )
                    	    {
                    	    // InternalSephirah.g:338:6: (lv_args_5_0= ruleDefinitionVariable )
                    	    // InternalSephirah.g:339:7: lv_args_5_0= ruleDefinitionVariable
                    	    {

                    	    							newCompositeNode(grammarAccess.getDefinitionAccess().getArgsDefinitionVariableParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_9);
                    	    lv_args_5_0=ruleDefinitionVariable();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getDefinitionRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"args",
                    	    								lv_args_5_0,
                    	    								"com.fearlesstyrant.sephirah.Sephirah.DefinitionVariable");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,18,FOLLOW_10); 

            			newLeafNode(otherlv_6, grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_4());
            		
            otherlv_7=(Token)match(input,19,FOLLOW_11); 

            			newLeafNode(otherlv_7, grammarAccess.getDefinitionAccess().getEqualsSignKeyword_5());
            		
            // InternalSephirah.g:366:3: ( (lv_expr_8_0= ruleExpression ) )
            // InternalSephirah.g:367:4: (lv_expr_8_0= ruleExpression )
            {
            // InternalSephirah.g:367:4: (lv_expr_8_0= ruleExpression )
            // InternalSephirah.g:368:5: lv_expr_8_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getDefinitionAccess().getExprExpressionParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_6);
            lv_expr_8_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDefinitionRule());
            					}
            					set(
            						current,
            						"expr",
            						lv_expr_8_0,
            						"com.fearlesstyrant.sephirah.Sephirah.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getDefinitionAccess().getSemicolonKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefinition"


    // $ANTLR start "entryRuleVariableAssignment"
    // InternalSephirah.g:393:1: entryRuleVariableAssignment returns [EObject current=null] : iv_ruleVariableAssignment= ruleVariableAssignment EOF ;
    public final EObject entryRuleVariableAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableAssignment = null;


        try {
            // InternalSephirah.g:393:59: (iv_ruleVariableAssignment= ruleVariableAssignment EOF )
            // InternalSephirah.g:394:2: iv_ruleVariableAssignment= ruleVariableAssignment EOF
            {
             newCompositeNode(grammarAccess.getVariableAssignmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableAssignment=ruleVariableAssignment();

            state._fsp--;

             current =iv_ruleVariableAssignment; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableAssignment"


    // $ANTLR start "ruleVariableAssignment"
    // InternalSephirah.g:400:1: ruleVariableAssignment returns [EObject current=null] : ( () otherlv_1= 'var' ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' ) ;
    public final EObject ruleVariableAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:406:2: ( ( () otherlv_1= 'var' ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' ) )
            // InternalSephirah.g:407:2: ( () otherlv_1= 'var' ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' )
            {
            // InternalSephirah.g:407:2: ( () otherlv_1= 'var' ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' )
            // InternalSephirah.g:408:3: () otherlv_1= 'var' ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';'
            {
            // InternalSephirah.g:408:3: ()
            // InternalSephirah.g:409:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVariableAssignmentAccess().getVariableAssignmentAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,20,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getVariableAssignmentAccess().getVarKeyword_1());
            		
            // InternalSephirah.g:419:3: ( (lv_name_2_0= ruleValidID ) )
            // InternalSephirah.g:420:4: (lv_name_2_0= ruleValidID )
            {
            // InternalSephirah.g:420:4: (lv_name_2_0= ruleValidID )
            // InternalSephirah.g:421:5: lv_name_2_0= ruleValidID
            {

            					newCompositeNode(grammarAccess.getVariableAssignmentAccess().getNameValidIDParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_10);
            lv_name_2_0=ruleValidID();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVariableAssignmentRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"com.fearlesstyrant.sephirah.Sephirah.ValidID");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_11); 

            			newLeafNode(otherlv_3, grammarAccess.getVariableAssignmentAccess().getEqualsSignKeyword_3());
            		
            // InternalSephirah.g:442:3: ( (lv_value_4_0= ruleExpression ) )
            // InternalSephirah.g:443:4: (lv_value_4_0= ruleExpression )
            {
            // InternalSephirah.g:443:4: (lv_value_4_0= ruleExpression )
            // InternalSephirah.g:444:5: lv_value_4_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getVariableAssignmentAccess().getValueExpressionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_6);
            lv_value_4_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVariableAssignmentRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_4_0,
            						"com.fearlesstyrant.sephirah.Sephirah.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getVariableAssignmentAccess().getSemicolonKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableAssignment"


    // $ANTLR start "entryRuleVariable"
    // InternalSephirah.g:469:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalSephirah.g:469:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalSephirah.g:470:2: iv_ruleVariable= ruleVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalSephirah.g:476:1: ruleVariable returns [EObject current=null] : ( () ( (lv_name_1_0= ruleQualifiedName ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:482:2: ( ( () ( (lv_name_1_0= ruleQualifiedName ) ) ) )
            // InternalSephirah.g:483:2: ( () ( (lv_name_1_0= ruleQualifiedName ) ) )
            {
            // InternalSephirah.g:483:2: ( () ( (lv_name_1_0= ruleQualifiedName ) ) )
            // InternalSephirah.g:484:3: () ( (lv_name_1_0= ruleQualifiedName ) )
            {
            // InternalSephirah.g:484:3: ()
            // InternalSephirah.g:485:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVariableAccess().getVariableAction_0(),
            					current);
            			

            }

            // InternalSephirah.g:491:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalSephirah.g:492:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalSephirah.g:492:4: (lv_name_1_0= ruleQualifiedName )
            // InternalSephirah.g:493:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getVariableAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVariableRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.fearlesstyrant.sephirah.Sephirah.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleDefinitionVariable"
    // InternalSephirah.g:514:1: entryRuleDefinitionVariable returns [EObject current=null] : iv_ruleDefinitionVariable= ruleDefinitionVariable EOF ;
    public final EObject entryRuleDefinitionVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinitionVariable = null;


        try {
            // InternalSephirah.g:514:59: (iv_ruleDefinitionVariable= ruleDefinitionVariable EOF )
            // InternalSephirah.g:515:2: iv_ruleDefinitionVariable= ruleDefinitionVariable EOF
            {
             newCompositeNode(grammarAccess.getDefinitionVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDefinitionVariable=ruleDefinitionVariable();

            state._fsp--;

             current =iv_ruleDefinitionVariable; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefinitionVariable"


    // $ANTLR start "ruleDefinitionVariable"
    // InternalSephirah.g:521:1: ruleDefinitionVariable returns [EObject current=null] : ( () ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleDefinitionVariable() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:527:2: ( ( () ( (lv_name_1_0= ruleValidID ) ) ) )
            // InternalSephirah.g:528:2: ( () ( (lv_name_1_0= ruleValidID ) ) )
            {
            // InternalSephirah.g:528:2: ( () ( (lv_name_1_0= ruleValidID ) ) )
            // InternalSephirah.g:529:3: () ( (lv_name_1_0= ruleValidID ) )
            {
            // InternalSephirah.g:529:3: ()
            // InternalSephirah.g:530:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDefinitionVariableAccess().getDefinitionVariableAction_0(),
            					current);
            			

            }

            // InternalSephirah.g:536:3: ( (lv_name_1_0= ruleValidID ) )
            // InternalSephirah.g:537:4: (lv_name_1_0= ruleValidID )
            {
            // InternalSephirah.g:537:4: (lv_name_1_0= ruleValidID )
            // InternalSephirah.g:538:5: lv_name_1_0= ruleValidID
            {

            					newCompositeNode(grammarAccess.getDefinitionVariableAccess().getNameValidIDParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleValidID();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDefinitionVariableRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.fearlesstyrant.sephirah.Sephirah.ValidID");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefinitionVariable"


    // $ANTLR start "entryRuleEvaluation"
    // InternalSephirah.g:559:1: entryRuleEvaluation returns [EObject current=null] : iv_ruleEvaluation= ruleEvaluation EOF ;
    public final EObject entryRuleEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvaluation = null;


        try {
            // InternalSephirah.g:559:51: (iv_ruleEvaluation= ruleEvaluation EOF )
            // InternalSephirah.g:560:2: iv_ruleEvaluation= ruleEvaluation EOF
            {
             newCompositeNode(grammarAccess.getEvaluationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEvaluation=ruleEvaluation();

            state._fsp--;

             current =iv_ruleEvaluation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEvaluation"


    // $ANTLR start "ruleEvaluation"
    // InternalSephirah.g:566:1: ruleEvaluation returns [EObject current=null] : ( ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';' ) ;
    public final EObject ruleEvaluation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_0_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:572:2: ( ( ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';' ) )
            // InternalSephirah.g:573:2: ( ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';' )
            {
            // InternalSephirah.g:573:2: ( ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';' )
            // InternalSephirah.g:574:3: ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';'
            {
            // InternalSephirah.g:574:3: ( (lv_expression_0_0= ruleExpression ) )
            // InternalSephirah.g:575:4: (lv_expression_0_0= ruleExpression )
            {
            // InternalSephirah.g:575:4: (lv_expression_0_0= ruleExpression )
            // InternalSephirah.g:576:5: lv_expression_0_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getEvaluationAccess().getExpressionExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_6);
            lv_expression_0_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEvaluationRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_0_0,
            						"com.fearlesstyrant.sephirah.Sephirah.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getEvaluationAccess().getSemicolonKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEvaluation"


    // $ANTLR start "entryRuleExpression"
    // InternalSephirah.g:601:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalSephirah.g:601:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalSephirah.g:602:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalSephirah.g:608:1: ruleExpression returns [EObject current=null] : this_Addition_0= ruleAddition ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Addition_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:614:2: (this_Addition_0= ruleAddition )
            // InternalSephirah.g:615:2: this_Addition_0= ruleAddition
            {

            		newCompositeNode(grammarAccess.getExpressionAccess().getAdditionParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_Addition_0=ruleAddition();

            state._fsp--;


            		current = this_Addition_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleAddition"
    // InternalSephirah.g:626:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // InternalSephirah.g:626:49: (iv_ruleAddition= ruleAddition EOF )
            // InternalSephirah.g:627:2: iv_ruleAddition= ruleAddition EOF
            {
             newCompositeNode(grammarAccess.getAdditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAddition=ruleAddition();

            state._fsp--;

             current =iv_ruleAddition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddition"


    // $ANTLR start "ruleAddition"
    // InternalSephirah.g:633:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:639:2: ( (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) )
            // InternalSephirah.g:640:2: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            {
            // InternalSephirah.g:640:2: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            // InternalSephirah.g:641:3: this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            {

            			newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0());
            		
            pushFollow(FOLLOW_12);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;


            			current = this_Multiplication_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSephirah.g:649:3: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=21 && LA7_0<=22)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalSephirah.g:650:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) )
            	    {
            	    // InternalSephirah.g:650:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==21) ) {
            	        alt6=1;
            	    }
            	    else if ( (LA6_0==22) ) {
            	        alt6=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 6, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // InternalSephirah.g:651:5: ( () otherlv_2= '+' )
            	            {
            	            // InternalSephirah.g:651:5: ( () otherlv_2= '+' )
            	            // InternalSephirah.g:652:6: () otherlv_2= '+'
            	            {
            	            // InternalSephirah.g:652:6: ()
            	            // InternalSephirah.g:653:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getAdditionAccess().getAddLeftAction_1_0_0_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_2=(Token)match(input,21,FOLLOW_11); 

            	            						newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalSephirah.g:665:5: ( () otherlv_4= '-' )
            	            {
            	            // InternalSephirah.g:665:5: ( () otherlv_4= '-' )
            	            // InternalSephirah.g:666:6: () otherlv_4= '-'
            	            {
            	            // InternalSephirah.g:666:6: ()
            	            // InternalSephirah.g:667:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getAdditionAccess().getSubtractLeftAction_1_0_1_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_4=(Token)match(input,22,FOLLOW_11); 

            	            						newLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalSephirah.g:679:4: ( (lv_right_5_0= ruleMultiplication ) )
            	    // InternalSephirah.g:680:5: (lv_right_5_0= ruleMultiplication )
            	    {
            	    // InternalSephirah.g:680:5: (lv_right_5_0= ruleMultiplication )
            	    // InternalSephirah.g:681:6: lv_right_5_0= ruleMultiplication
            	    {

            	    						newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_12);
            	    lv_right_5_0=ruleMultiplication();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAdditionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_5_0,
            	    							"com.fearlesstyrant.sephirah.Sephirah.Multiplication");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleMultiplication"
    // InternalSephirah.g:703:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // InternalSephirah.g:703:55: (iv_ruleMultiplication= ruleMultiplication EOF )
            // InternalSephirah.g:704:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
             newCompositeNode(grammarAccess.getMultiplicationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMultiplication=ruleMultiplication();

            state._fsp--;

             current =iv_ruleMultiplication; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplication"


    // $ANTLR start "ruleMultiplication"
    // InternalSephirah.g:710:1: ruleMultiplication returns [EObject current=null] : (this_Exponent_0= ruleExponent ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleExponent ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Exponent_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:716:2: ( (this_Exponent_0= ruleExponent ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleExponent ) ) )* ) )
            // InternalSephirah.g:717:2: (this_Exponent_0= ruleExponent ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleExponent ) ) )* )
            {
            // InternalSephirah.g:717:2: (this_Exponent_0= ruleExponent ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleExponent ) ) )* )
            // InternalSephirah.g:718:3: this_Exponent_0= ruleExponent ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleExponent ) ) )*
            {

            			newCompositeNode(grammarAccess.getMultiplicationAccess().getExponentParserRuleCall_0());
            		
            pushFollow(FOLLOW_13);
            this_Exponent_0=ruleExponent();

            state._fsp--;


            			current = this_Exponent_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSephirah.g:726:3: ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleExponent ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=23 && LA9_0<=24)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalSephirah.g:727:4: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleExponent ) )
            	    {
            	    // InternalSephirah.g:727:4: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) )
            	    int alt8=2;
            	    int LA8_0 = input.LA(1);

            	    if ( (LA8_0==23) ) {
            	        alt8=1;
            	    }
            	    else if ( (LA8_0==24) ) {
            	        alt8=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 8, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt8) {
            	        case 1 :
            	            // InternalSephirah.g:728:5: ( () otherlv_2= '*' )
            	            {
            	            // InternalSephirah.g:728:5: ( () otherlv_2= '*' )
            	            // InternalSephirah.g:729:6: () otherlv_2= '*'
            	            {
            	            // InternalSephirah.g:729:6: ()
            	            // InternalSephirah.g:730:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getMultiplicationAccess().getMultiplyLeftAction_1_0_0_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_2=(Token)match(input,23,FOLLOW_11); 

            	            						newLeafNode(otherlv_2, grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalSephirah.g:742:5: ( () otherlv_4= '/' )
            	            {
            	            // InternalSephirah.g:742:5: ( () otherlv_4= '/' )
            	            // InternalSephirah.g:743:6: () otherlv_4= '/'
            	            {
            	            // InternalSephirah.g:743:6: ()
            	            // InternalSephirah.g:744:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getMultiplicationAccess().getDivideLeftAction_1_0_1_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_4=(Token)match(input,24,FOLLOW_11); 

            	            						newLeafNode(otherlv_4, grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_0_1_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalSephirah.g:756:4: ( (lv_right_5_0= ruleExponent ) )
            	    // InternalSephirah.g:757:5: (lv_right_5_0= ruleExponent )
            	    {
            	    // InternalSephirah.g:757:5: (lv_right_5_0= ruleExponent )
            	    // InternalSephirah.g:758:6: lv_right_5_0= ruleExponent
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplicationAccess().getRightExponentParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    lv_right_5_0=ruleExponent();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMultiplicationRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_5_0,
            	    							"com.fearlesstyrant.sephirah.Sephirah.Exponent");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRuleExponent"
    // InternalSephirah.g:780:1: entryRuleExponent returns [EObject current=null] : iv_ruleExponent= ruleExponent EOF ;
    public final EObject entryRuleExponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExponent = null;


        try {
            // InternalSephirah.g:780:49: (iv_ruleExponent= ruleExponent EOF )
            // InternalSephirah.g:781:2: iv_ruleExponent= ruleExponent EOF
            {
             newCompositeNode(grammarAccess.getExponentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExponent=ruleExponent();

            state._fsp--;

             current =iv_ruleExponent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExponent"


    // $ANTLR start "ruleExponent"
    // InternalSephirah.g:787:1: ruleExponent returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '^' ( (lv_right_3_0= ruleExponent ) ) )? ) ;
    public final EObject ruleExponent() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_PrimaryExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:793:2: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '^' ( (lv_right_3_0= ruleExponent ) ) )? ) )
            // InternalSephirah.g:794:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '^' ( (lv_right_3_0= ruleExponent ) ) )? )
            {
            // InternalSephirah.g:794:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '^' ( (lv_right_3_0= ruleExponent ) ) )? )
            // InternalSephirah.g:795:3: this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '^' ( (lv_right_3_0= ruleExponent ) ) )?
            {

            			newCompositeNode(grammarAccess.getExponentAccess().getPrimaryExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_14);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;


            			current = this_PrimaryExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSephirah.g:803:3: ( () otherlv_2= '^' ( (lv_right_3_0= ruleExponent ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==25) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalSephirah.g:804:4: () otherlv_2= '^' ( (lv_right_3_0= ruleExponent ) )
                    {
                    // InternalSephirah.g:804:4: ()
                    // InternalSephirah.g:805:5: 
                    {

                    					current = forceCreateModelElementAndSet(
                    						grammarAccess.getExponentAccess().getExponentLeftAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_2=(Token)match(input,25,FOLLOW_11); 

                    				newLeafNode(otherlv_2, grammarAccess.getExponentAccess().getCircumflexAccentKeyword_1_1());
                    			
                    // InternalSephirah.g:815:4: ( (lv_right_3_0= ruleExponent ) )
                    // InternalSephirah.g:816:5: (lv_right_3_0= ruleExponent )
                    {
                    // InternalSephirah.g:816:5: (lv_right_3_0= ruleExponent )
                    // InternalSephirah.g:817:6: lv_right_3_0= ruleExponent
                    {

                    						newCompositeNode(grammarAccess.getExponentAccess().getRightExponentParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleExponent();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExponentRule());
                    						}
                    						set(
                    							current,
                    							"right",
                    							lv_right_3_0,
                    							"com.fearlesstyrant.sephirah.Sephirah.Exponent");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExponent"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalSephirah.g:839:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalSephirah.g:839:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalSephirah.g:840:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalSephirah.g:846:1: rulePrimaryExpression returns [EObject current=null] : ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= ruleDecimal ) ) ) | this_MethodCall_5= ruleMethodCall | this_Constant_6= ruleConstant | this_Variable_7= ruleVariable ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Expression_1 = null;

        AntlrDatatypeRuleToken lv_value_4_0 = null;

        EObject this_MethodCall_5 = null;

        EObject this_Constant_6 = null;

        EObject this_Variable_7 = null;



        	enterRule();

        try {
            // InternalSephirah.g:852:2: ( ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= ruleDecimal ) ) ) | this_MethodCall_5= ruleMethodCall | this_Constant_6= ruleConstant | this_Variable_7= ruleVariable ) )
            // InternalSephirah.g:853:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= ruleDecimal ) ) ) | this_MethodCall_5= ruleMethodCall | this_Constant_6= ruleConstant | this_Variable_7= ruleVariable )
            {
            // InternalSephirah.g:853:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= ruleDecimal ) ) ) | this_MethodCall_5= ruleMethodCall | this_Constant_6= ruleConstant | this_Variable_7= ruleVariable )
            int alt11=5;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // InternalSephirah.g:854:3: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    {
                    // InternalSephirah.g:854:3: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    // InternalSephirah.g:855:4: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,16,FOLLOW_11); 

                    				newLeafNode(otherlv_0, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_0());
                    			

                    				newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_15);
                    this_Expression_1=ruleExpression();

                    state._fsp--;


                    				current = this_Expression_1;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_2=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_2());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSephirah.g:873:3: ( () ( (lv_value_4_0= ruleDecimal ) ) )
                    {
                    // InternalSephirah.g:873:3: ( () ( (lv_value_4_0= ruleDecimal ) ) )
                    // InternalSephirah.g:874:4: () ( (lv_value_4_0= ruleDecimal ) )
                    {
                    // InternalSephirah.g:874:4: ()
                    // InternalSephirah.g:875:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimaryExpressionAccess().getNumberLiteralAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSephirah.g:881:4: ( (lv_value_4_0= ruleDecimal ) )
                    // InternalSephirah.g:882:5: (lv_value_4_0= ruleDecimal )
                    {
                    // InternalSephirah.g:882:5: (lv_value_4_0= ruleDecimal )
                    // InternalSephirah.g:883:6: lv_value_4_0= ruleDecimal
                    {

                    						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getValueDecimalParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_4_0=ruleDecimal();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_4_0,
                    							"com.fearlesstyrant.sephirah.Sephirah.Decimal");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSephirah.g:902:3: this_MethodCall_5= ruleMethodCall
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getMethodCallParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_MethodCall_5=ruleMethodCall();

                    state._fsp--;


                    			current = this_MethodCall_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalSephirah.g:911:3: this_Constant_6= ruleConstant
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getConstantParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Constant_6=ruleConstant();

                    state._fsp--;


                    			current = this_Constant_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalSephirah.g:920:3: this_Variable_7= ruleVariable
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getVariableParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Variable_7=ruleVariable();

                    state._fsp--;


                    			current = this_Variable_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleMethodCall"
    // InternalSephirah.g:932:1: entryRuleMethodCall returns [EObject current=null] : iv_ruleMethodCall= ruleMethodCall EOF ;
    public final EObject entryRuleMethodCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodCall = null;


        try {
            // InternalSephirah.g:932:51: (iv_ruleMethodCall= ruleMethodCall EOF )
            // InternalSephirah.g:933:2: iv_ruleMethodCall= ruleMethodCall EOF
            {
             newCompositeNode(grammarAccess.getMethodCallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMethodCall=ruleMethodCall();

            state._fsp--;

             current =iv_ruleMethodCall; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMethodCall"


    // $ANTLR start "ruleMethodCall"
    // InternalSephirah.g:939:1: ruleMethodCall returns [EObject current=null] : ( () ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) ;
    public final EObject ruleMethodCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_args_3_0 = null;

        EObject lv_args_5_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:945:2: ( ( () ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) )
            // InternalSephirah.g:946:2: ( () ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            {
            // InternalSephirah.g:946:2: ( () ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            // InternalSephirah.g:947:3: () ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')'
            {
            // InternalSephirah.g:947:3: ()
            // InternalSephirah.g:948:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMethodCallAccess().getMethodCallAction_0(),
            					current);
            			

            }

            // InternalSephirah.g:954:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalSephirah.g:955:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalSephirah.g:955:4: (lv_name_1_0= ruleQualifiedName )
            // InternalSephirah.g:956:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getMethodCallAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_7);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMethodCallRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"com.fearlesstyrant.sephirah.Sephirah.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getMethodCallAccess().getLeftParenthesisKeyword_2());
            		
            // InternalSephirah.g:977:3: ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=RULE_ID && LA13_0<=RULE_INT)||LA13_0==16||(LA13_0>=26 && LA13_0<=30)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalSephirah.g:978:4: ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    {
                    // InternalSephirah.g:978:4: ( (lv_args_3_0= ruleExpression ) )
                    // InternalSephirah.g:979:5: (lv_args_3_0= ruleExpression )
                    {
                    // InternalSephirah.g:979:5: (lv_args_3_0= ruleExpression )
                    // InternalSephirah.g:980:6: lv_args_3_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getMethodCallAccess().getArgsExpressionParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_9);
                    lv_args_3_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMethodCallRule());
                    						}
                    						add(
                    							current,
                    							"args",
                    							lv_args_3_0,
                    							"com.fearlesstyrant.sephirah.Sephirah.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalSephirah.g:997:4: (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==17) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalSephirah.g:998:5: otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,17,FOLLOW_11); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getMethodCallAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalSephirah.g:1002:5: ( (lv_args_5_0= ruleExpression ) )
                    	    // InternalSephirah.g:1003:6: (lv_args_5_0= ruleExpression )
                    	    {
                    	    // InternalSephirah.g:1003:6: (lv_args_5_0= ruleExpression )
                    	    // InternalSephirah.g:1004:7: lv_args_5_0= ruleExpression
                    	    {

                    	    							newCompositeNode(grammarAccess.getMethodCallAccess().getArgsExpressionParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_9);
                    	    lv_args_5_0=ruleExpression();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getMethodCallRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"args",
                    	    								lv_args_5_0,
                    	    								"com.fearlesstyrant.sephirah.Sephirah.Expression");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getMethodCallAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMethodCall"


    // $ANTLR start "entryRuleConstant"
    // InternalSephirah.g:1031:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalSephirah.g:1031:49: (iv_ruleConstant= ruleConstant EOF )
            // InternalSephirah.g:1032:2: iv_ruleConstant= ruleConstant EOF
            {
             newCompositeNode(grammarAccess.getConstantRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstant=ruleConstant();

            state._fsp--;

             current =iv_ruleConstant; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstant"


    // $ANTLR start "ruleConstant"
    // InternalSephirah.g:1038:1: ruleConstant returns [EObject current=null] : ( () ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) ) ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_1=null;
        Token lv_value_1_2=null;
        Token lv_value_1_3=null;
        Token lv_value_1_4=null;
        Token lv_value_1_5=null;


        	enterRule();

        try {
            // InternalSephirah.g:1044:2: ( ( () ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) ) ) )
            // InternalSephirah.g:1045:2: ( () ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) ) )
            {
            // InternalSephirah.g:1045:2: ( () ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) ) )
            // InternalSephirah.g:1046:3: () ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) )
            {
            // InternalSephirah.g:1046:3: ()
            // InternalSephirah.g:1047:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getConstantAccess().getConstantAction_0(),
            					current);
            			

            }

            // InternalSephirah.g:1053:3: ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) )
            // InternalSephirah.g:1054:4: ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) )
            {
            // InternalSephirah.g:1054:4: ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) )
            // InternalSephirah.g:1055:5: (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' )
            {
            // InternalSephirah.g:1055:5: (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' )
            int alt14=5;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt14=1;
                }
                break;
            case 27:
                {
                alt14=2;
                }
                break;
            case 28:
                {
                alt14=3;
                }
                break;
            case 29:
                {
                alt14=4;
                }
                break;
            case 30:
                {
                alt14=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalSephirah.g:1056:6: lv_value_1_1= 'pi'
                    {
                    lv_value_1_1=(Token)match(input,26,FOLLOW_2); 

                    						newLeafNode(lv_value_1_1, grammarAccess.getConstantAccess().getValuePiKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstantRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalSephirah.g:1067:6: lv_value_1_2= 'G'
                    {
                    lv_value_1_2=(Token)match(input,27,FOLLOW_2); 

                    						newLeafNode(lv_value_1_2, grammarAccess.getConstantAccess().getValueGKeyword_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstantRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalSephirah.g:1078:6: lv_value_1_3= 'phi'
                    {
                    lv_value_1_3=(Token)match(input,28,FOLLOW_2); 

                    						newLeafNode(lv_value_1_3, grammarAccess.getConstantAccess().getValuePhiKeyword_1_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstantRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_3, null);
                    					

                    }
                    break;
                case 4 :
                    // InternalSephirah.g:1089:6: lv_value_1_4= 'gamma'
                    {
                    lv_value_1_4=(Token)match(input,29,FOLLOW_2); 

                    						newLeafNode(lv_value_1_4, grammarAccess.getConstantAccess().getValueGammaKeyword_1_0_3());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstantRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_4, null);
                    					

                    }
                    break;
                case 5 :
                    // InternalSephirah.g:1100:6: lv_value_1_5= 'e'
                    {
                    lv_value_1_5=(Token)match(input,30,FOLLOW_2); 

                    						newLeafNode(lv_value_1_5, grammarAccess.getConstantAccess().getValueEKeyword_1_0_4());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstantRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_5, null);
                    					

                    }
                    break;

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstant"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalSephirah.g:1117:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalSephirah.g:1117:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalSephirah.g:1118:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalSephirah.g:1124:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;



        	enterRule();

        try {
            // InternalSephirah.g:1130:2: ( (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* ) )
            // InternalSephirah.g:1131:2: (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* )
            {
            // InternalSephirah.g:1131:2: (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* )
            // InternalSephirah.g:1132:3: this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )*
            {

            			newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0());
            		
            pushFollow(FOLLOW_17);
            this_ValidID_0=ruleValidID();

            state._fsp--;


            			current.merge(this_ValidID_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalSephirah.g:1142:3: (kw= '.' this_ValidID_2= ruleValidID )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==31) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalSephirah.g:1143:4: kw= '.' this_ValidID_2= ruleValidID
            	    {
            	    kw=(Token)match(input,31,FOLLOW_5); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			

            	    				newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1());
            	    			
            	    pushFollow(FOLLOW_17);
            	    this_ValidID_2=ruleValidID();

            	    state._fsp--;


            	    				current.merge(this_ValidID_2);
            	    			

            	    				afterParserOrEnumRuleCall();
            	    			

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleValidID"
    // InternalSephirah.g:1163:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // InternalSephirah.g:1163:47: (iv_ruleValidID= ruleValidID EOF )
            // InternalSephirah.g:1164:2: iv_ruleValidID= ruleValidID EOF
            {
             newCompositeNode(grammarAccess.getValidIDRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValidID=ruleValidID();

            state._fsp--;

             current =iv_ruleValidID.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // InternalSephirah.g:1170:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_ESCAPED_ID_1=null;


        	enterRule();

        try {
            // InternalSephirah.g:1176:2: ( (this_ID_0= RULE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) )
            // InternalSephirah.g:1177:2: (this_ID_0= RULE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            {
            // InternalSephirah.g:1177:2: (this_ID_0= RULE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            else if ( (LA16_0==RULE_ESCAPED_ID) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalSephirah.g:1178:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_0);
                    		

                    			newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSephirah.g:1186:3: this_ESCAPED_ID_1= RULE_ESCAPED_ID
                    {
                    this_ESCAPED_ID_1=(Token)match(input,RULE_ESCAPED_ID,FOLLOW_2); 

                    			current.merge(this_ESCAPED_ID_1);
                    		

                    			newLeafNode(this_ESCAPED_ID_1, grammarAccess.getValidIDAccess().getESCAPED_IDTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValidID"


    // $ANTLR start "entryRuleDecimal"
    // InternalSephirah.g:1197:1: entryRuleDecimal returns [String current=null] : iv_ruleDecimal= ruleDecimal EOF ;
    public final String entryRuleDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimal = null;


        try {
            // InternalSephirah.g:1197:47: (iv_ruleDecimal= ruleDecimal EOF )
            // InternalSephirah.g:1198:2: iv_ruleDecimal= ruleDecimal EOF
            {
             newCompositeNode(grammarAccess.getDecimalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDecimal=ruleDecimal();

            state._fsp--;

             current =iv_ruleDecimal.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDecimal"


    // $ANTLR start "ruleDecimal"
    // InternalSephirah.g:1204:1: ruleDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalSephirah.g:1210:2: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) )
            // InternalSephirah.g:1211:2: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            {
            // InternalSephirah.g:1211:2: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            // InternalSephirah.g:1212:3: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )?
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_17); 

            			current.merge(this_INT_0);
            		

            			newLeafNode(this_INT_0, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_0());
            		
            // InternalSephirah.g:1219:3: (kw= '.' this_INT_2= RULE_INT )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==31) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalSephirah.g:1220:4: kw= '.' this_INT_2= RULE_INT
                    {
                    kw=(Token)match(input,31,FOLLOW_18); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getDecimalAccess().getFullStopKeyword_1_0());
                    			
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_2); 

                    				current.merge(this_INT_2);
                    			

                    				newLeafNode(this_INT_2, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_1_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDecimal"

    // Delegated rules


    protected DFA11 dfa11 = new DFA11(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\3\uffff\2\10\4\uffff\2\10";
    static final String dfa_3s = "\1\4\2\uffff\2\16\1\uffff\1\4\2\uffff\2\16";
    static final String dfa_4s = "\1\36\2\uffff\2\37\1\uffff\1\5\2\uffff\2\37";
    static final String dfa_5s = "\1\uffff\1\1\1\2\2\uffff\1\4\1\uffff\1\3\1\5\2\uffff";
    static final String dfa_6s = "\13\uffff}>";
    static final String[] dfa_7s = {
            "\1\3\1\4\1\2\11\uffff\1\1\11\uffff\5\5",
            "",
            "",
            "\1\10\1\uffff\1\7\2\10\2\uffff\5\10\5\uffff\1\6",
            "\1\10\1\uffff\1\7\2\10\2\uffff\5\10\5\uffff\1\6",
            "",
            "\1\11\1\12",
            "",
            "",
            "\1\10\1\uffff\1\7\2\10\2\uffff\5\10\5\uffff\1\6",
            "\1\10\1\uffff\1\7\2\10\2\uffff\5\10\5\uffff\1\6"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "853:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= ruleDecimal ) ) ) | this_MethodCall_5= ruleMethodCall | this_Constant_6= ruleConstant | this_Variable_7= ruleVariable )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000007C11A072L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000007C118072L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000040030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x000000007C118070L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001800002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000000007C158070L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000040L});

}