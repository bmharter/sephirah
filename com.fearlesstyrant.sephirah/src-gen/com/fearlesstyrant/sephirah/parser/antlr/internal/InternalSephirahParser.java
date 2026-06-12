package com.fearlesstyrant.sephirah.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_ESCAPED_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'SephirahDoc'", "'import'", "';'", "'def'", "'('", "','", "')'", "'='", "'var'", "'if'", "'then'", "'else'", "'or'", "'and'", "'not'", "'['", "']'", "'+'", "'-'", "'*'", "'/'", "'^'", "'true'", "'false'", "'pi'", "'G'", "'phi'", "'gamma'", "'e'", "'.'", "'<='", "'>='", "'=='", "'!='", "'<'", "'>'"
    };
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int RULE_ID=4;
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
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int RULE_ESCAPED_ID=5;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

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
    // InternalSephirah.g:65:1: entryRuleFormulaModel returns [EObject current=null] : iv_ruleFormulaModel= ruleFormulaModel EOF ;
    public final EObject entryRuleFormulaModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormulaModel = null;


        try {
            // InternalSephirah.g:65:53: (iv_ruleFormulaModel= ruleFormulaModel EOF )
            // InternalSephirah.g:66:2: iv_ruleFormulaModel= ruleFormulaModel EOF
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
    // InternalSephirah.g:72:1: ruleFormulaModel returns [EObject current=null] : ( ( (lv_name_0_0= ruleDocName ) )? ( (lv_imports_1_0= ruleImport ) )* ( ( (lv_methodDefs_2_0= ruleDefinition ) ) | ( (lv_variables_3_0= ruleVariableAssignment ) ) | ( (lv_values_4_0= ruleEvaluation ) ) )* ) ;
    public final EObject ruleFormulaModel() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;

        EObject lv_imports_1_0 = null;

        EObject lv_methodDefs_2_0 = null;

        EObject lv_variables_3_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:78:2: ( ( ( (lv_name_0_0= ruleDocName ) )? ( (lv_imports_1_0= ruleImport ) )* ( ( (lv_methodDefs_2_0= ruleDefinition ) ) | ( (lv_variables_3_0= ruleVariableAssignment ) ) | ( (lv_values_4_0= ruleEvaluation ) ) )* ) )
            // InternalSephirah.g:79:2: ( ( (lv_name_0_0= ruleDocName ) )? ( (lv_imports_1_0= ruleImport ) )* ( ( (lv_methodDefs_2_0= ruleDefinition ) ) | ( (lv_variables_3_0= ruleVariableAssignment ) ) | ( (lv_values_4_0= ruleEvaluation ) ) )* )
            {
            // InternalSephirah.g:79:2: ( ( (lv_name_0_0= ruleDocName ) )? ( (lv_imports_1_0= ruleImport ) )* ( ( (lv_methodDefs_2_0= ruleDefinition ) ) | ( (lv_variables_3_0= ruleVariableAssignment ) ) | ( (lv_values_4_0= ruleEvaluation ) ) )* )
            // InternalSephirah.g:80:3: ( (lv_name_0_0= ruleDocName ) )? ( (lv_imports_1_0= ruleImport ) )* ( ( (lv_methodDefs_2_0= ruleDefinition ) ) | ( (lv_variables_3_0= ruleVariableAssignment ) ) | ( (lv_values_4_0= ruleEvaluation ) ) )*
            {
            // InternalSephirah.g:80:3: ( (lv_name_0_0= ruleDocName ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalSephirah.g:81:4: (lv_name_0_0= ruleDocName )
                    {
                    // InternalSephirah.g:81:4: (lv_name_0_0= ruleDocName )
                    // InternalSephirah.g:82:5: lv_name_0_0= ruleDocName
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

            // InternalSephirah.g:99:3: ( (lv_imports_1_0= ruleImport ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalSephirah.g:100:4: (lv_imports_1_0= ruleImport )
            	    {
            	    // InternalSephirah.g:100:4: (lv_imports_1_0= ruleImport )
            	    // InternalSephirah.g:101:5: lv_imports_1_0= ruleImport
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

            // InternalSephirah.g:118:3: ( ( (lv_methodDefs_2_0= ruleDefinition ) ) | ( (lv_variables_3_0= ruleVariableAssignment ) ) | ( (lv_values_4_0= ruleEvaluation ) ) )*
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
                case 21:
                case 26:
                case 27:
                case 30:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                    {
                    alt3=3;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // InternalSephirah.g:119:4: ( (lv_methodDefs_2_0= ruleDefinition ) )
            	    {
            	    // InternalSephirah.g:119:4: ( (lv_methodDefs_2_0= ruleDefinition ) )
            	    // InternalSephirah.g:120:5: (lv_methodDefs_2_0= ruleDefinition )
            	    {
            	    // InternalSephirah.g:120:5: (lv_methodDefs_2_0= ruleDefinition )
            	    // InternalSephirah.g:121:6: lv_methodDefs_2_0= ruleDefinition
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
            	    // InternalSephirah.g:139:4: ( (lv_variables_3_0= ruleVariableAssignment ) )
            	    {
            	    // InternalSephirah.g:139:4: ( (lv_variables_3_0= ruleVariableAssignment ) )
            	    // InternalSephirah.g:140:5: (lv_variables_3_0= ruleVariableAssignment )
            	    {
            	    // InternalSephirah.g:140:5: (lv_variables_3_0= ruleVariableAssignment )
            	    // InternalSephirah.g:141:6: lv_variables_3_0= ruleVariableAssignment
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
            	    // InternalSephirah.g:159:4: ( (lv_values_4_0= ruleEvaluation ) )
            	    {
            	    // InternalSephirah.g:159:4: ( (lv_values_4_0= ruleEvaluation ) )
            	    // InternalSephirah.g:160:5: (lv_values_4_0= ruleEvaluation )
            	    {
            	    // InternalSephirah.g:160:5: (lv_values_4_0= ruleEvaluation )
            	    // InternalSephirah.g:161:6: lv_values_4_0= ruleEvaluation
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
    // InternalSephirah.g:183:1: entryRuleDocName returns [EObject current=null] : iv_ruleDocName= ruleDocName EOF ;
    public final EObject entryRuleDocName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocName = null;


        try {
            // InternalSephirah.g:183:48: (iv_ruleDocName= ruleDocName EOF )
            // InternalSephirah.g:184:2: iv_ruleDocName= ruleDocName EOF
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
    // InternalSephirah.g:190:1: ruleDocName returns [EObject current=null] : (otherlv_0= 'SephirahDoc' ( (lv_name_1_0= ruleQualifiedName ) ) ) ;
    public final EObject ruleDocName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:196:2: ( (otherlv_0= 'SephirahDoc' ( (lv_name_1_0= ruleQualifiedName ) ) ) )
            // InternalSephirah.g:197:2: (otherlv_0= 'SephirahDoc' ( (lv_name_1_0= ruleQualifiedName ) ) )
            {
            // InternalSephirah.g:197:2: (otherlv_0= 'SephirahDoc' ( (lv_name_1_0= ruleQualifiedName ) ) )
            // InternalSephirah.g:198:3: otherlv_0= 'SephirahDoc' ( (lv_name_1_0= ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getDocNameAccess().getSephirahDocKeyword_0());
            		
            // InternalSephirah.g:202:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalSephirah.g:203:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalSephirah.g:203:4: (lv_name_1_0= ruleQualifiedName )
            // InternalSephirah.g:204:5: lv_name_1_0= ruleQualifiedName
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
    // InternalSephirah.g:225:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalSephirah.g:225:47: (iv_ruleImport= ruleImport EOF )
            // InternalSephirah.g:226:2: iv_ruleImport= ruleImport EOF
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
    // InternalSephirah.g:232:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= ';' ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:238:2: ( (otherlv_0= 'import' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= ';' ) )
            // InternalSephirah.g:239:2: (otherlv_0= 'import' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= ';' )
            {
            // InternalSephirah.g:239:2: (otherlv_0= 'import' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= ';' )
            // InternalSephirah.g:240:3: otherlv_0= 'import' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalSephirah.g:244:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalSephirah.g:245:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalSephirah.g:245:4: (lv_name_1_0= ruleQualifiedName )
            // InternalSephirah.g:246:5: lv_name_1_0= ruleQualifiedName
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
    // InternalSephirah.g:271:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // InternalSephirah.g:271:51: (iv_ruleDefinition= ruleDefinition EOF )
            // InternalSephirah.g:272:2: iv_ruleDefinition= ruleDefinition EOF
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
    // InternalSephirah.g:278:1: ruleDefinition returns [EObject current=null] : (otherlv_0= 'def' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )* )? otherlv_6= ')' otherlv_7= '=' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';' ) ;
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
            // InternalSephirah.g:284:2: ( (otherlv_0= 'def' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )* )? otherlv_6= ')' otherlv_7= '=' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
            // InternalSephirah.g:285:2: (otherlv_0= 'def' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )* )? otherlv_6= ')' otherlv_7= '=' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';' )
            {
            // InternalSephirah.g:285:2: (otherlv_0= 'def' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )* )? otherlv_6= ')' otherlv_7= '=' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';' )
            // InternalSephirah.g:286:3: otherlv_0= 'def' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )* )? otherlv_6= ')' otherlv_7= '=' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getDefinitionAccess().getDefKeyword_0());
            		
            // InternalSephirah.g:290:3: ( (lv_name_1_0= ruleValidID ) )
            // InternalSephirah.g:291:4: (lv_name_1_0= ruleValidID )
            {
            // InternalSephirah.g:291:4: (lv_name_1_0= ruleValidID )
            // InternalSephirah.g:292:5: lv_name_1_0= ruleValidID
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
            		
            // InternalSephirah.g:313:3: ( ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=RULE_ID && LA5_0<=RULE_ESCAPED_ID)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalSephirah.g:314:4: ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )*
                    {
                    // InternalSephirah.g:314:4: ( (lv_args_3_0= ruleDefinitionVariable ) )
                    // InternalSephirah.g:315:5: (lv_args_3_0= ruleDefinitionVariable )
                    {
                    // InternalSephirah.g:315:5: (lv_args_3_0= ruleDefinitionVariable )
                    // InternalSephirah.g:316:6: lv_args_3_0= ruleDefinitionVariable
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

                    // InternalSephirah.g:333:4: (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==17) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalSephirah.g:334:5: otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) )
                    	    {
                    	    otherlv_4=(Token)match(input,17,FOLLOW_5); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getDefinitionAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalSephirah.g:338:5: ( (lv_args_5_0= ruleDefinitionVariable ) )
                    	    // InternalSephirah.g:339:6: (lv_args_5_0= ruleDefinitionVariable )
                    	    {
                    	    // InternalSephirah.g:339:6: (lv_args_5_0= ruleDefinitionVariable )
                    	    // InternalSephirah.g:340:7: lv_args_5_0= ruleDefinitionVariable
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
            		
            // InternalSephirah.g:367:3: ( (lv_expr_8_0= ruleExpression ) )
            // InternalSephirah.g:368:4: (lv_expr_8_0= ruleExpression )
            {
            // InternalSephirah.g:368:4: (lv_expr_8_0= ruleExpression )
            // InternalSephirah.g:369:5: lv_expr_8_0= ruleExpression
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
    // InternalSephirah.g:394:1: entryRuleVariableAssignment returns [EObject current=null] : iv_ruleVariableAssignment= ruleVariableAssignment EOF ;
    public final EObject entryRuleVariableAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableAssignment = null;


        try {
            // InternalSephirah.g:394:59: (iv_ruleVariableAssignment= ruleVariableAssignment EOF )
            // InternalSephirah.g:395:2: iv_ruleVariableAssignment= ruleVariableAssignment EOF
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
    // InternalSephirah.g:401:1: ruleVariableAssignment returns [EObject current=null] : ( () otherlv_1= 'var' ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' ) ;
    public final EObject ruleVariableAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:407:2: ( ( () otherlv_1= 'var' ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' ) )
            // InternalSephirah.g:408:2: ( () otherlv_1= 'var' ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' )
            {
            // InternalSephirah.g:408:2: ( () otherlv_1= 'var' ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' )
            // InternalSephirah.g:409:3: () otherlv_1= 'var' ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';'
            {
            // InternalSephirah.g:409:3: ()
            // InternalSephirah.g:410:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVariableAssignmentAccess().getVariableAssignmentAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,20,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getVariableAssignmentAccess().getVarKeyword_1());
            		
            // InternalSephirah.g:420:3: ( (lv_name_2_0= ruleValidID ) )
            // InternalSephirah.g:421:4: (lv_name_2_0= ruleValidID )
            {
            // InternalSephirah.g:421:4: (lv_name_2_0= ruleValidID )
            // InternalSephirah.g:422:5: lv_name_2_0= ruleValidID
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
            		
            // InternalSephirah.g:443:3: ( (lv_value_4_0= ruleExpression ) )
            // InternalSephirah.g:444:4: (lv_value_4_0= ruleExpression )
            {
            // InternalSephirah.g:444:4: (lv_value_4_0= ruleExpression )
            // InternalSephirah.g:445:5: lv_value_4_0= ruleExpression
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
    // InternalSephirah.g:470:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalSephirah.g:470:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalSephirah.g:471:2: iv_ruleVariable= ruleVariable EOF
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
    // InternalSephirah.g:477:1: ruleVariable returns [EObject current=null] : ( () ( (lv_name_1_0= ruleQualifiedName ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:483:2: ( ( () ( (lv_name_1_0= ruleQualifiedName ) ) ) )
            // InternalSephirah.g:484:2: ( () ( (lv_name_1_0= ruleQualifiedName ) ) )
            {
            // InternalSephirah.g:484:2: ( () ( (lv_name_1_0= ruleQualifiedName ) ) )
            // InternalSephirah.g:485:3: () ( (lv_name_1_0= ruleQualifiedName ) )
            {
            // InternalSephirah.g:485:3: ()
            // InternalSephirah.g:486:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVariableAccess().getVariableAction_0(),
            					current);
            			

            }

            // InternalSephirah.g:492:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalSephirah.g:493:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalSephirah.g:493:4: (lv_name_1_0= ruleQualifiedName )
            // InternalSephirah.g:494:5: lv_name_1_0= ruleQualifiedName
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
    // InternalSephirah.g:515:1: entryRuleDefinitionVariable returns [EObject current=null] : iv_ruleDefinitionVariable= ruleDefinitionVariable EOF ;
    public final EObject entryRuleDefinitionVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinitionVariable = null;


        try {
            // InternalSephirah.g:515:59: (iv_ruleDefinitionVariable= ruleDefinitionVariable EOF )
            // InternalSephirah.g:516:2: iv_ruleDefinitionVariable= ruleDefinitionVariable EOF
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
    // InternalSephirah.g:522:1: ruleDefinitionVariable returns [EObject current=null] : ( () ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleDefinitionVariable() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:528:2: ( ( () ( (lv_name_1_0= ruleValidID ) ) ) )
            // InternalSephirah.g:529:2: ( () ( (lv_name_1_0= ruleValidID ) ) )
            {
            // InternalSephirah.g:529:2: ( () ( (lv_name_1_0= ruleValidID ) ) )
            // InternalSephirah.g:530:3: () ( (lv_name_1_0= ruleValidID ) )
            {
            // InternalSephirah.g:530:3: ()
            // InternalSephirah.g:531:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDefinitionVariableAccess().getDefinitionVariableAction_0(),
            					current);
            			

            }

            // InternalSephirah.g:537:3: ( (lv_name_1_0= ruleValidID ) )
            // InternalSephirah.g:538:4: (lv_name_1_0= ruleValidID )
            {
            // InternalSephirah.g:538:4: (lv_name_1_0= ruleValidID )
            // InternalSephirah.g:539:5: lv_name_1_0= ruleValidID
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
    // InternalSephirah.g:560:1: entryRuleEvaluation returns [EObject current=null] : iv_ruleEvaluation= ruleEvaluation EOF ;
    public final EObject entryRuleEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvaluation = null;


        try {
            // InternalSephirah.g:560:51: (iv_ruleEvaluation= ruleEvaluation EOF )
            // InternalSephirah.g:561:2: iv_ruleEvaluation= ruleEvaluation EOF
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
    // InternalSephirah.g:567:1: ruleEvaluation returns [EObject current=null] : ( ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';' ) ;
    public final EObject ruleEvaluation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_0_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:573:2: ( ( ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';' ) )
            // InternalSephirah.g:574:2: ( ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';' )
            {
            // InternalSephirah.g:574:2: ( ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';' )
            // InternalSephirah.g:575:3: ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';'
            {
            // InternalSephirah.g:575:3: ( (lv_expression_0_0= ruleExpression ) )
            // InternalSephirah.g:576:4: (lv_expression_0_0= ruleExpression )
            {
            // InternalSephirah.g:576:4: (lv_expression_0_0= ruleExpression )
            // InternalSephirah.g:577:5: lv_expression_0_0= ruleExpression
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
    // InternalSephirah.g:602:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalSephirah.g:602:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalSephirah.g:603:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalSephirah.g:609:1: ruleExpression returns [EObject current=null] : this_ConditionalExpression_0= ruleConditionalExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ConditionalExpression_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:615:2: (this_ConditionalExpression_0= ruleConditionalExpression )
            // InternalSephirah.g:616:2: this_ConditionalExpression_0= ruleConditionalExpression
            {

            		newCompositeNode(grammarAccess.getExpressionAccess().getConditionalExpressionParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_ConditionalExpression_0=ruleConditionalExpression();

            state._fsp--;


            		current = this_ConditionalExpression_0;
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


    // $ANTLR start "entryRuleConditionalExpression"
    // InternalSephirah.g:627:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // InternalSephirah.g:627:62: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // InternalSephirah.g:628:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
            {
             newCompositeNode(grammarAccess.getConditionalExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConditionalExpression=ruleConditionalExpression();

            state._fsp--;

             current =iv_ruleConditionalExpression; 
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
    // $ANTLR end "entryRuleConditionalExpression"


    // $ANTLR start "ruleConditionalExpression"
    // InternalSephirah.g:634:1: ruleConditionalExpression returns [EObject current=null] : ( ( () otherlv_1= 'if' ( (lv_condition_2_0= ruleBooleanExpression ) ) otherlv_3= 'then' ( (lv_thenBranch_4_0= ruleExpression ) ) otherlv_5= 'else' ( (lv_elseBranch_6_0= ruleExpression ) ) ) | this_BooleanExpression_7= ruleBooleanExpression ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_condition_2_0 = null;

        EObject lv_thenBranch_4_0 = null;

        EObject lv_elseBranch_6_0 = null;

        EObject this_BooleanExpression_7 = null;



        	enterRule();

        try {
            // InternalSephirah.g:640:2: ( ( ( () otherlv_1= 'if' ( (lv_condition_2_0= ruleBooleanExpression ) ) otherlv_3= 'then' ( (lv_thenBranch_4_0= ruleExpression ) ) otherlv_5= 'else' ( (lv_elseBranch_6_0= ruleExpression ) ) ) | this_BooleanExpression_7= ruleBooleanExpression ) )
            // InternalSephirah.g:641:2: ( ( () otherlv_1= 'if' ( (lv_condition_2_0= ruleBooleanExpression ) ) otherlv_3= 'then' ( (lv_thenBranch_4_0= ruleExpression ) ) otherlv_5= 'else' ( (lv_elseBranch_6_0= ruleExpression ) ) ) | this_BooleanExpression_7= ruleBooleanExpression )
            {
            // InternalSephirah.g:641:2: ( ( () otherlv_1= 'if' ( (lv_condition_2_0= ruleBooleanExpression ) ) otherlv_3= 'then' ( (lv_thenBranch_4_0= ruleExpression ) ) otherlv_5= 'else' ( (lv_elseBranch_6_0= ruleExpression ) ) ) | this_BooleanExpression_7= ruleBooleanExpression )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==21) ) {
                alt6=1;
            }
            else if ( ((LA6_0>=RULE_ID && LA6_0<=RULE_INT)||LA6_0==16||(LA6_0>=26 && LA6_0<=27)||LA6_0==30||(LA6_0>=34 && LA6_0<=40)) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalSephirah.g:642:3: ( () otherlv_1= 'if' ( (lv_condition_2_0= ruleBooleanExpression ) ) otherlv_3= 'then' ( (lv_thenBranch_4_0= ruleExpression ) ) otherlv_5= 'else' ( (lv_elseBranch_6_0= ruleExpression ) ) )
                    {
                    // InternalSephirah.g:642:3: ( () otherlv_1= 'if' ( (lv_condition_2_0= ruleBooleanExpression ) ) otherlv_3= 'then' ( (lv_thenBranch_4_0= ruleExpression ) ) otherlv_5= 'else' ( (lv_elseBranch_6_0= ruleExpression ) ) )
                    // InternalSephirah.g:643:4: () otherlv_1= 'if' ( (lv_condition_2_0= ruleBooleanExpression ) ) otherlv_3= 'then' ( (lv_thenBranch_4_0= ruleExpression ) ) otherlv_5= 'else' ( (lv_elseBranch_6_0= ruleExpression ) )
                    {
                    // InternalSephirah.g:643:4: ()
                    // InternalSephirah.g:644:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getConditionalExpressionAccess().getConditionalAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,21,FOLLOW_11); 

                    				newLeafNode(otherlv_1, grammarAccess.getConditionalExpressionAccess().getIfKeyword_0_1());
                    			
                    // InternalSephirah.g:654:4: ( (lv_condition_2_0= ruleBooleanExpression ) )
                    // InternalSephirah.g:655:5: (lv_condition_2_0= ruleBooleanExpression )
                    {
                    // InternalSephirah.g:655:5: (lv_condition_2_0= ruleBooleanExpression )
                    // InternalSephirah.g:656:6: lv_condition_2_0= ruleBooleanExpression
                    {

                    						newCompositeNode(grammarAccess.getConditionalExpressionAccess().getConditionBooleanExpressionParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_condition_2_0=ruleBooleanExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
                    						}
                    						set(
                    							current,
                    							"condition",
                    							lv_condition_2_0,
                    							"com.fearlesstyrant.sephirah.Sephirah.BooleanExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,22,FOLLOW_11); 

                    				newLeafNode(otherlv_3, grammarAccess.getConditionalExpressionAccess().getThenKeyword_0_3());
                    			
                    // InternalSephirah.g:677:4: ( (lv_thenBranch_4_0= ruleExpression ) )
                    // InternalSephirah.g:678:5: (lv_thenBranch_4_0= ruleExpression )
                    {
                    // InternalSephirah.g:678:5: (lv_thenBranch_4_0= ruleExpression )
                    // InternalSephirah.g:679:6: lv_thenBranch_4_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getConditionalExpressionAccess().getThenBranchExpressionParserRuleCall_0_4_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_thenBranch_4_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
                    						}
                    						set(
                    							current,
                    							"thenBranch",
                    							lv_thenBranch_4_0,
                    							"com.fearlesstyrant.sephirah.Sephirah.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,23,FOLLOW_11); 

                    				newLeafNode(otherlv_5, grammarAccess.getConditionalExpressionAccess().getElseKeyword_0_5());
                    			
                    // InternalSephirah.g:700:4: ( (lv_elseBranch_6_0= ruleExpression ) )
                    // InternalSephirah.g:701:5: (lv_elseBranch_6_0= ruleExpression )
                    {
                    // InternalSephirah.g:701:5: (lv_elseBranch_6_0= ruleExpression )
                    // InternalSephirah.g:702:6: lv_elseBranch_6_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getConditionalExpressionAccess().getElseBranchExpressionParserRuleCall_0_6_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_elseBranch_6_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
                    						}
                    						set(
                    							current,
                    							"elseBranch",
                    							lv_elseBranch_6_0,
                    							"com.fearlesstyrant.sephirah.Sephirah.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSephirah.g:721:3: this_BooleanExpression_7= ruleBooleanExpression
                    {

                    			newCompositeNode(grammarAccess.getConditionalExpressionAccess().getBooleanExpressionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_BooleanExpression_7=ruleBooleanExpression();

                    state._fsp--;


                    			current = this_BooleanExpression_7;
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
    // $ANTLR end "ruleConditionalExpression"


    // $ANTLR start "entryRuleBooleanExpression"
    // InternalSephirah.g:733:1: entryRuleBooleanExpression returns [EObject current=null] : iv_ruleBooleanExpression= ruleBooleanExpression EOF ;
    public final EObject entryRuleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanExpression = null;


        try {
            // InternalSephirah.g:733:58: (iv_ruleBooleanExpression= ruleBooleanExpression EOF )
            // InternalSephirah.g:734:2: iv_ruleBooleanExpression= ruleBooleanExpression EOF
            {
             newCompositeNode(grammarAccess.getBooleanExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanExpression=ruleBooleanExpression();

            state._fsp--;

             current =iv_ruleBooleanExpression; 
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
    // $ANTLR end "entryRuleBooleanExpression"


    // $ANTLR start "ruleBooleanExpression"
    // InternalSephirah.g:740:1: ruleBooleanExpression returns [EObject current=null] : this_OrBooleanExpression_0= ruleOrBooleanExpression ;
    public final EObject ruleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject this_OrBooleanExpression_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:746:2: (this_OrBooleanExpression_0= ruleOrBooleanExpression )
            // InternalSephirah.g:747:2: this_OrBooleanExpression_0= ruleOrBooleanExpression
            {

            		newCompositeNode(grammarAccess.getBooleanExpressionAccess().getOrBooleanExpressionParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_OrBooleanExpression_0=ruleOrBooleanExpression();

            state._fsp--;


            		current = this_OrBooleanExpression_0;
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
    // $ANTLR end "ruleBooleanExpression"


    // $ANTLR start "entryRuleOrBooleanExpression"
    // InternalSephirah.g:758:1: entryRuleOrBooleanExpression returns [EObject current=null] : iv_ruleOrBooleanExpression= ruleOrBooleanExpression EOF ;
    public final EObject entryRuleOrBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrBooleanExpression = null;


        try {
            // InternalSephirah.g:758:60: (iv_ruleOrBooleanExpression= ruleOrBooleanExpression EOF )
            // InternalSephirah.g:759:2: iv_ruleOrBooleanExpression= ruleOrBooleanExpression EOF
            {
             newCompositeNode(grammarAccess.getOrBooleanExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrBooleanExpression=ruleOrBooleanExpression();

            state._fsp--;

             current =iv_ruleOrBooleanExpression; 
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
    // $ANTLR end "entryRuleOrBooleanExpression"


    // $ANTLR start "ruleOrBooleanExpression"
    // InternalSephirah.g:765:1: ruleOrBooleanExpression returns [EObject current=null] : (this_AndBooleanExpression_0= ruleAndBooleanExpression ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndBooleanExpression ) ) )* ) ;
    public final EObject ruleOrBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndBooleanExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:771:2: ( (this_AndBooleanExpression_0= ruleAndBooleanExpression ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndBooleanExpression ) ) )* ) )
            // InternalSephirah.g:772:2: (this_AndBooleanExpression_0= ruleAndBooleanExpression ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndBooleanExpression ) ) )* )
            {
            // InternalSephirah.g:772:2: (this_AndBooleanExpression_0= ruleAndBooleanExpression ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndBooleanExpression ) ) )* )
            // InternalSephirah.g:773:3: this_AndBooleanExpression_0= ruleAndBooleanExpression ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndBooleanExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrBooleanExpressionAccess().getAndBooleanExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_14);
            this_AndBooleanExpression_0=ruleAndBooleanExpression();

            state._fsp--;


            			current = this_AndBooleanExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSephirah.g:781:3: ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndBooleanExpression ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==24) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalSephirah.g:782:4: () otherlv_2= 'or' ( (lv_right_3_0= ruleAndBooleanExpression ) )
            	    {
            	    // InternalSephirah.g:782:4: ()
            	    // InternalSephirah.g:783:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getOrBooleanExpressionAccess().getOrConditionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,24,FOLLOW_11); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOrBooleanExpressionAccess().getOrKeyword_1_1());
            	    			
            	    // InternalSephirah.g:793:4: ( (lv_right_3_0= ruleAndBooleanExpression ) )
            	    // InternalSephirah.g:794:5: (lv_right_3_0= ruleAndBooleanExpression )
            	    {
            	    // InternalSephirah.g:794:5: (lv_right_3_0= ruleAndBooleanExpression )
            	    // InternalSephirah.g:795:6: lv_right_3_0= ruleAndBooleanExpression
            	    {

            	    						newCompositeNode(grammarAccess.getOrBooleanExpressionAccess().getRightAndBooleanExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_14);
            	    lv_right_3_0=ruleAndBooleanExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOrBooleanExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"com.fearlesstyrant.sephirah.Sephirah.AndBooleanExpression");
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
    // $ANTLR end "ruleOrBooleanExpression"


    // $ANTLR start "entryRuleAndBooleanExpression"
    // InternalSephirah.g:817:1: entryRuleAndBooleanExpression returns [EObject current=null] : iv_ruleAndBooleanExpression= ruleAndBooleanExpression EOF ;
    public final EObject entryRuleAndBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndBooleanExpression = null;


        try {
            // InternalSephirah.g:817:61: (iv_ruleAndBooleanExpression= ruleAndBooleanExpression EOF )
            // InternalSephirah.g:818:2: iv_ruleAndBooleanExpression= ruleAndBooleanExpression EOF
            {
             newCompositeNode(grammarAccess.getAndBooleanExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndBooleanExpression=ruleAndBooleanExpression();

            state._fsp--;

             current =iv_ruleAndBooleanExpression; 
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
    // $ANTLR end "entryRuleAndBooleanExpression"


    // $ANTLR start "ruleAndBooleanExpression"
    // InternalSephirah.g:824:1: ruleAndBooleanExpression returns [EObject current=null] : (this_NotBooleanExpression_0= ruleNotBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleNotBooleanExpression ) ) )* ) ;
    public final EObject ruleAndBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_NotBooleanExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:830:2: ( (this_NotBooleanExpression_0= ruleNotBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleNotBooleanExpression ) ) )* ) )
            // InternalSephirah.g:831:2: (this_NotBooleanExpression_0= ruleNotBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleNotBooleanExpression ) ) )* )
            {
            // InternalSephirah.g:831:2: (this_NotBooleanExpression_0= ruleNotBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleNotBooleanExpression ) ) )* )
            // InternalSephirah.g:832:3: this_NotBooleanExpression_0= ruleNotBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleNotBooleanExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndBooleanExpressionAccess().getNotBooleanExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_15);
            this_NotBooleanExpression_0=ruleNotBooleanExpression();

            state._fsp--;


            			current = this_NotBooleanExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSephirah.g:840:3: ( () otherlv_2= 'and' ( (lv_right_3_0= ruleNotBooleanExpression ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==25) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalSephirah.g:841:4: () otherlv_2= 'and' ( (lv_right_3_0= ruleNotBooleanExpression ) )
            	    {
            	    // InternalSephirah.g:841:4: ()
            	    // InternalSephirah.g:842:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndBooleanExpressionAccess().getAndConditionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,25,FOLLOW_11); 

            	    				newLeafNode(otherlv_2, grammarAccess.getAndBooleanExpressionAccess().getAndKeyword_1_1());
            	    			
            	    // InternalSephirah.g:852:4: ( (lv_right_3_0= ruleNotBooleanExpression ) )
            	    // InternalSephirah.g:853:5: (lv_right_3_0= ruleNotBooleanExpression )
            	    {
            	    // InternalSephirah.g:853:5: (lv_right_3_0= ruleNotBooleanExpression )
            	    // InternalSephirah.g:854:6: lv_right_3_0= ruleNotBooleanExpression
            	    {

            	    						newCompositeNode(grammarAccess.getAndBooleanExpressionAccess().getRightNotBooleanExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_15);
            	    lv_right_3_0=ruleNotBooleanExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndBooleanExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"com.fearlesstyrant.sephirah.Sephirah.NotBooleanExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // $ANTLR end "ruleAndBooleanExpression"


    // $ANTLR start "entryRuleNotBooleanExpression"
    // InternalSephirah.g:876:1: entryRuleNotBooleanExpression returns [EObject current=null] : iv_ruleNotBooleanExpression= ruleNotBooleanExpression EOF ;
    public final EObject entryRuleNotBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotBooleanExpression = null;


        try {
            // InternalSephirah.g:876:61: (iv_ruleNotBooleanExpression= ruleNotBooleanExpression EOF )
            // InternalSephirah.g:877:2: iv_ruleNotBooleanExpression= ruleNotBooleanExpression EOF
            {
             newCompositeNode(grammarAccess.getNotBooleanExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNotBooleanExpression=ruleNotBooleanExpression();

            state._fsp--;

             current =iv_ruleNotBooleanExpression; 
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
    // $ANTLR end "entryRuleNotBooleanExpression"


    // $ANTLR start "ruleNotBooleanExpression"
    // InternalSephirah.g:883:1: ruleNotBooleanExpression returns [EObject current=null] : ( ( () otherlv_1= 'not' ( (lv_condition_2_0= ruleNotBooleanExpression ) ) ) | this_PrimaryBooleanExpression_3= rulePrimaryBooleanExpression ) ;
    public final EObject ruleNotBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_condition_2_0 = null;

        EObject this_PrimaryBooleanExpression_3 = null;



        	enterRule();

        try {
            // InternalSephirah.g:889:2: ( ( ( () otherlv_1= 'not' ( (lv_condition_2_0= ruleNotBooleanExpression ) ) ) | this_PrimaryBooleanExpression_3= rulePrimaryBooleanExpression ) )
            // InternalSephirah.g:890:2: ( ( () otherlv_1= 'not' ( (lv_condition_2_0= ruleNotBooleanExpression ) ) ) | this_PrimaryBooleanExpression_3= rulePrimaryBooleanExpression )
            {
            // InternalSephirah.g:890:2: ( ( () otherlv_1= 'not' ( (lv_condition_2_0= ruleNotBooleanExpression ) ) ) | this_PrimaryBooleanExpression_3= rulePrimaryBooleanExpression )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==26) ) {
                alt9=1;
            }
            else if ( ((LA9_0>=RULE_ID && LA9_0<=RULE_INT)||LA9_0==16||LA9_0==27||LA9_0==30||(LA9_0>=34 && LA9_0<=40)) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalSephirah.g:891:3: ( () otherlv_1= 'not' ( (lv_condition_2_0= ruleNotBooleanExpression ) ) )
                    {
                    // InternalSephirah.g:891:3: ( () otherlv_1= 'not' ( (lv_condition_2_0= ruleNotBooleanExpression ) ) )
                    // InternalSephirah.g:892:4: () otherlv_1= 'not' ( (lv_condition_2_0= ruleNotBooleanExpression ) )
                    {
                    // InternalSephirah.g:892:4: ()
                    // InternalSephirah.g:893:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getNotBooleanExpressionAccess().getNotConditionAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,26,FOLLOW_11); 

                    				newLeafNode(otherlv_1, grammarAccess.getNotBooleanExpressionAccess().getNotKeyword_0_1());
                    			
                    // InternalSephirah.g:903:4: ( (lv_condition_2_0= ruleNotBooleanExpression ) )
                    // InternalSephirah.g:904:5: (lv_condition_2_0= ruleNotBooleanExpression )
                    {
                    // InternalSephirah.g:904:5: (lv_condition_2_0= ruleNotBooleanExpression )
                    // InternalSephirah.g:905:6: lv_condition_2_0= ruleNotBooleanExpression
                    {

                    						newCompositeNode(grammarAccess.getNotBooleanExpressionAccess().getConditionNotBooleanExpressionParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_condition_2_0=ruleNotBooleanExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNotBooleanExpressionRule());
                    						}
                    						set(
                    							current,
                    							"condition",
                    							lv_condition_2_0,
                    							"com.fearlesstyrant.sephirah.Sephirah.NotBooleanExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSephirah.g:924:3: this_PrimaryBooleanExpression_3= rulePrimaryBooleanExpression
                    {

                    			newCompositeNode(grammarAccess.getNotBooleanExpressionAccess().getPrimaryBooleanExpressionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_PrimaryBooleanExpression_3=rulePrimaryBooleanExpression();

                    state._fsp--;


                    			current = this_PrimaryBooleanExpression_3;
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
    // $ANTLR end "ruleNotBooleanExpression"


    // $ANTLR start "entryRulePrimaryBooleanExpression"
    // InternalSephirah.g:936:1: entryRulePrimaryBooleanExpression returns [EObject current=null] : iv_rulePrimaryBooleanExpression= rulePrimaryBooleanExpression EOF ;
    public final EObject entryRulePrimaryBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryBooleanExpression = null;


        try {
            // InternalSephirah.g:936:65: (iv_rulePrimaryBooleanExpression= rulePrimaryBooleanExpression EOF )
            // InternalSephirah.g:937:2: iv_rulePrimaryBooleanExpression= rulePrimaryBooleanExpression EOF
            {
             newCompositeNode(grammarAccess.getPrimaryBooleanExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimaryBooleanExpression=rulePrimaryBooleanExpression();

            state._fsp--;

             current =iv_rulePrimaryBooleanExpression; 
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
    // $ANTLR end "entryRulePrimaryBooleanExpression"


    // $ANTLR start "rulePrimaryBooleanExpression"
    // InternalSephirah.g:943:1: rulePrimaryBooleanExpression returns [EObject current=null] : ( (otherlv_0= '[' this_BooleanExpression_1= ruleBooleanExpression otherlv_2= ']' ) | (this_Addition_3= ruleAddition ( () ( (lv_op_5_0= ruleComparisonOperator ) ) ( (lv_right_6_0= ruleAddition ) ) )? ) ) ;
    public final EObject rulePrimaryBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_BooleanExpression_1 = null;

        EObject this_Addition_3 = null;

        Enumerator lv_op_5_0 = null;

        EObject lv_right_6_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:949:2: ( ( (otherlv_0= '[' this_BooleanExpression_1= ruleBooleanExpression otherlv_2= ']' ) | (this_Addition_3= ruleAddition ( () ( (lv_op_5_0= ruleComparisonOperator ) ) ( (lv_right_6_0= ruleAddition ) ) )? ) ) )
            // InternalSephirah.g:950:2: ( (otherlv_0= '[' this_BooleanExpression_1= ruleBooleanExpression otherlv_2= ']' ) | (this_Addition_3= ruleAddition ( () ( (lv_op_5_0= ruleComparisonOperator ) ) ( (lv_right_6_0= ruleAddition ) ) )? ) )
            {
            // InternalSephirah.g:950:2: ( (otherlv_0= '[' this_BooleanExpression_1= ruleBooleanExpression otherlv_2= ']' ) | (this_Addition_3= ruleAddition ( () ( (lv_op_5_0= ruleComparisonOperator ) ) ( (lv_right_6_0= ruleAddition ) ) )? ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==27) ) {
                alt11=1;
            }
            else if ( ((LA11_0>=RULE_ID && LA11_0<=RULE_INT)||LA11_0==16||LA11_0==30||(LA11_0>=34 && LA11_0<=40)) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalSephirah.g:951:3: (otherlv_0= '[' this_BooleanExpression_1= ruleBooleanExpression otherlv_2= ']' )
                    {
                    // InternalSephirah.g:951:3: (otherlv_0= '[' this_BooleanExpression_1= ruleBooleanExpression otherlv_2= ']' )
                    // InternalSephirah.g:952:4: otherlv_0= '[' this_BooleanExpression_1= ruleBooleanExpression otherlv_2= ']'
                    {
                    otherlv_0=(Token)match(input,27,FOLLOW_11); 

                    				newLeafNode(otherlv_0, grammarAccess.getPrimaryBooleanExpressionAccess().getLeftSquareBracketKeyword_0_0());
                    			

                    				newCompositeNode(grammarAccess.getPrimaryBooleanExpressionAccess().getBooleanExpressionParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_16);
                    this_BooleanExpression_1=ruleBooleanExpression();

                    state._fsp--;


                    				current = this_BooleanExpression_1;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_2=(Token)match(input,28,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getPrimaryBooleanExpressionAccess().getRightSquareBracketKeyword_0_2());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSephirah.g:970:3: (this_Addition_3= ruleAddition ( () ( (lv_op_5_0= ruleComparisonOperator ) ) ( (lv_right_6_0= ruleAddition ) ) )? )
                    {
                    // InternalSephirah.g:970:3: (this_Addition_3= ruleAddition ( () ( (lv_op_5_0= ruleComparisonOperator ) ) ( (lv_right_6_0= ruleAddition ) ) )? )
                    // InternalSephirah.g:971:4: this_Addition_3= ruleAddition ( () ( (lv_op_5_0= ruleComparisonOperator ) ) ( (lv_right_6_0= ruleAddition ) ) )?
                    {

                    				newCompositeNode(grammarAccess.getPrimaryBooleanExpressionAccess().getAdditionParserRuleCall_1_0());
                    			
                    pushFollow(FOLLOW_17);
                    this_Addition_3=ruleAddition();

                    state._fsp--;


                    				current = this_Addition_3;
                    				afterParserOrEnumRuleCall();
                    			
                    // InternalSephirah.g:979:4: ( () ( (lv_op_5_0= ruleComparisonOperator ) ) ( (lv_right_6_0= ruleAddition ) ) )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( ((LA10_0>=42 && LA10_0<=47)) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalSephirah.g:980:5: () ( (lv_op_5_0= ruleComparisonOperator ) ) ( (lv_right_6_0= ruleAddition ) )
                            {
                            // InternalSephirah.g:980:5: ()
                            // InternalSephirah.g:981:6: 
                            {

                            						current = forceCreateModelElementAndSet(
                            							grammarAccess.getPrimaryBooleanExpressionAccess().getComparisonConditionLeftAction_1_1_0(),
                            							current);
                            					

                            }

                            // InternalSephirah.g:987:5: ( (lv_op_5_0= ruleComparisonOperator ) )
                            // InternalSephirah.g:988:6: (lv_op_5_0= ruleComparisonOperator )
                            {
                            // InternalSephirah.g:988:6: (lv_op_5_0= ruleComparisonOperator )
                            // InternalSephirah.g:989:7: lv_op_5_0= ruleComparisonOperator
                            {

                            							newCompositeNode(grammarAccess.getPrimaryBooleanExpressionAccess().getOpComparisonOperatorEnumRuleCall_1_1_1_0());
                            						
                            pushFollow(FOLLOW_11);
                            lv_op_5_0=ruleComparisonOperator();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getPrimaryBooleanExpressionRule());
                            							}
                            							set(
                            								current,
                            								"op",
                            								lv_op_5_0,
                            								"com.fearlesstyrant.sephirah.Sephirah.ComparisonOperator");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalSephirah.g:1006:5: ( (lv_right_6_0= ruleAddition ) )
                            // InternalSephirah.g:1007:6: (lv_right_6_0= ruleAddition )
                            {
                            // InternalSephirah.g:1007:6: (lv_right_6_0= ruleAddition )
                            // InternalSephirah.g:1008:7: lv_right_6_0= ruleAddition
                            {

                            							newCompositeNode(grammarAccess.getPrimaryBooleanExpressionAccess().getRightAdditionParserRuleCall_1_1_2_0());
                            						
                            pushFollow(FOLLOW_2);
                            lv_right_6_0=ruleAddition();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getPrimaryBooleanExpressionRule());
                            							}
                            							set(
                            								current,
                            								"right",
                            								lv_right_6_0,
                            								"com.fearlesstyrant.sephirah.Sephirah.Addition");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }


                    }


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
    // $ANTLR end "rulePrimaryBooleanExpression"


    // $ANTLR start "entryRuleAddition"
    // InternalSephirah.g:1031:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // InternalSephirah.g:1031:49: (iv_ruleAddition= ruleAddition EOF )
            // InternalSephirah.g:1032:2: iv_ruleAddition= ruleAddition EOF
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
    // InternalSephirah.g:1038:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:1044:2: ( (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) )
            // InternalSephirah.g:1045:2: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            {
            // InternalSephirah.g:1045:2: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            // InternalSephirah.g:1046:3: this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            {

            			newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0());
            		
            pushFollow(FOLLOW_18);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;


            			current = this_Multiplication_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSephirah.g:1054:3: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=29 && LA13_0<=30)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalSephirah.g:1055:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) )
            	    {
            	    // InternalSephirah.g:1055:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt12=2;
            	    int LA12_0 = input.LA(1);

            	    if ( (LA12_0==29) ) {
            	        alt12=1;
            	    }
            	    else if ( (LA12_0==30) ) {
            	        alt12=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 12, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt12) {
            	        case 1 :
            	            // InternalSephirah.g:1056:5: ( () otherlv_2= '+' )
            	            {
            	            // InternalSephirah.g:1056:5: ( () otherlv_2= '+' )
            	            // InternalSephirah.g:1057:6: () otherlv_2= '+'
            	            {
            	            // InternalSephirah.g:1057:6: ()
            	            // InternalSephirah.g:1058:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getAdditionAccess().getAddLeftAction_1_0_0_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_2=(Token)match(input,29,FOLLOW_11); 

            	            						newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalSephirah.g:1070:5: ( () otherlv_4= '-' )
            	            {
            	            // InternalSephirah.g:1070:5: ( () otherlv_4= '-' )
            	            // InternalSephirah.g:1071:6: () otherlv_4= '-'
            	            {
            	            // InternalSephirah.g:1071:6: ()
            	            // InternalSephirah.g:1072:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getAdditionAccess().getSubtractLeftAction_1_0_1_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_4=(Token)match(input,30,FOLLOW_11); 

            	            						newLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalSephirah.g:1084:4: ( (lv_right_5_0= ruleMultiplication ) )
            	    // InternalSephirah.g:1085:5: (lv_right_5_0= ruleMultiplication )
            	    {
            	    // InternalSephirah.g:1085:5: (lv_right_5_0= ruleMultiplication )
            	    // InternalSephirah.g:1086:6: lv_right_5_0= ruleMultiplication
            	    {

            	    						newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_18);
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
            	    break loop13;
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
    // InternalSephirah.g:1108:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // InternalSephirah.g:1108:55: (iv_ruleMultiplication= ruleMultiplication EOF )
            // InternalSephirah.g:1109:2: iv_ruleMultiplication= ruleMultiplication EOF
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
    // InternalSephirah.g:1115:1: ruleMultiplication returns [EObject current=null] : (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleUnary ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Unary_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:1121:2: ( (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleUnary ) ) )* ) )
            // InternalSephirah.g:1122:2: (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleUnary ) ) )* )
            {
            // InternalSephirah.g:1122:2: (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleUnary ) ) )* )
            // InternalSephirah.g:1123:3: this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleUnary ) ) )*
            {

            			newCompositeNode(grammarAccess.getMultiplicationAccess().getUnaryParserRuleCall_0());
            		
            pushFollow(FOLLOW_19);
            this_Unary_0=ruleUnary();

            state._fsp--;


            			current = this_Unary_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSephirah.g:1131:3: ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleUnary ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=31 && LA15_0<=32)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalSephirah.g:1132:4: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleUnary ) )
            	    {
            	    // InternalSephirah.g:1132:4: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) )
            	    int alt14=2;
            	    int LA14_0 = input.LA(1);

            	    if ( (LA14_0==31) ) {
            	        alt14=1;
            	    }
            	    else if ( (LA14_0==32) ) {
            	        alt14=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 14, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt14) {
            	        case 1 :
            	            // InternalSephirah.g:1133:5: ( () otherlv_2= '*' )
            	            {
            	            // InternalSephirah.g:1133:5: ( () otherlv_2= '*' )
            	            // InternalSephirah.g:1134:6: () otherlv_2= '*'
            	            {
            	            // InternalSephirah.g:1134:6: ()
            	            // InternalSephirah.g:1135:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getMultiplicationAccess().getMultiplyLeftAction_1_0_0_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_2=(Token)match(input,31,FOLLOW_11); 

            	            						newLeafNode(otherlv_2, grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalSephirah.g:1147:5: ( () otherlv_4= '/' )
            	            {
            	            // InternalSephirah.g:1147:5: ( () otherlv_4= '/' )
            	            // InternalSephirah.g:1148:6: () otherlv_4= '/'
            	            {
            	            // InternalSephirah.g:1148:6: ()
            	            // InternalSephirah.g:1149:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getMultiplicationAccess().getDivideLeftAction_1_0_1_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_4=(Token)match(input,32,FOLLOW_11); 

            	            						newLeafNode(otherlv_4, grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_0_1_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalSephirah.g:1161:4: ( (lv_right_5_0= ruleUnary ) )
            	    // InternalSephirah.g:1162:5: (lv_right_5_0= ruleUnary )
            	    {
            	    // InternalSephirah.g:1162:5: (lv_right_5_0= ruleUnary )
            	    // InternalSephirah.g:1163:6: lv_right_5_0= ruleUnary
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplicationAccess().getRightUnaryParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_19);
            	    lv_right_5_0=ruleUnary();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMultiplicationRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_5_0,
            	    							"com.fearlesstyrant.sephirah.Sephirah.Unary");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


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
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRuleUnary"
    // InternalSephirah.g:1185:1: entryRuleUnary returns [EObject current=null] : iv_ruleUnary= ruleUnary EOF ;
    public final EObject entryRuleUnary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnary = null;


        try {
            // InternalSephirah.g:1185:46: (iv_ruleUnary= ruleUnary EOF )
            // InternalSephirah.g:1186:2: iv_ruleUnary= ruleUnary EOF
            {
             newCompositeNode(grammarAccess.getUnaryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnary=ruleUnary();

            state._fsp--;

             current =iv_ruleUnary; 
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
    // $ANTLR end "entryRuleUnary"


    // $ANTLR start "ruleUnary"
    // InternalSephirah.g:1192:1: ruleUnary returns [EObject current=null] : ( ( () otherlv_1= '-' ( (lv_value_2_0= ruleUnary ) ) ) | this_Exponent_3= ruleExponent ) ;
    public final EObject ruleUnary() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;

        EObject this_Exponent_3 = null;



        	enterRule();

        try {
            // InternalSephirah.g:1198:2: ( ( ( () otherlv_1= '-' ( (lv_value_2_0= ruleUnary ) ) ) | this_Exponent_3= ruleExponent ) )
            // InternalSephirah.g:1199:2: ( ( () otherlv_1= '-' ( (lv_value_2_0= ruleUnary ) ) ) | this_Exponent_3= ruleExponent )
            {
            // InternalSephirah.g:1199:2: ( ( () otherlv_1= '-' ( (lv_value_2_0= ruleUnary ) ) ) | this_Exponent_3= ruleExponent )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==30) ) {
                alt16=1;
            }
            else if ( ((LA16_0>=RULE_ID && LA16_0<=RULE_INT)||LA16_0==16||(LA16_0>=34 && LA16_0<=40)) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalSephirah.g:1200:3: ( () otherlv_1= '-' ( (lv_value_2_0= ruleUnary ) ) )
                    {
                    // InternalSephirah.g:1200:3: ( () otherlv_1= '-' ( (lv_value_2_0= ruleUnary ) ) )
                    // InternalSephirah.g:1201:4: () otherlv_1= '-' ( (lv_value_2_0= ruleUnary ) )
                    {
                    // InternalSephirah.g:1201:4: ()
                    // InternalSephirah.g:1202:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getUnaryAccess().getNegateAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,30,FOLLOW_11); 

                    				newLeafNode(otherlv_1, grammarAccess.getUnaryAccess().getHyphenMinusKeyword_0_1());
                    			
                    // InternalSephirah.g:1212:4: ( (lv_value_2_0= ruleUnary ) )
                    // InternalSephirah.g:1213:5: (lv_value_2_0= ruleUnary )
                    {
                    // InternalSephirah.g:1213:5: (lv_value_2_0= ruleUnary )
                    // InternalSephirah.g:1214:6: lv_value_2_0= ruleUnary
                    {

                    						newCompositeNode(grammarAccess.getUnaryAccess().getValueUnaryParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_2_0=ruleUnary();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getUnaryRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_2_0,
                    							"com.fearlesstyrant.sephirah.Sephirah.Unary");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSephirah.g:1233:3: this_Exponent_3= ruleExponent
                    {

                    			newCompositeNode(grammarAccess.getUnaryAccess().getExponentParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Exponent_3=ruleExponent();

                    state._fsp--;


                    			current = this_Exponent_3;
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
    // $ANTLR end "ruleUnary"


    // $ANTLR start "entryRuleExponent"
    // InternalSephirah.g:1245:1: entryRuleExponent returns [EObject current=null] : iv_ruleExponent= ruleExponent EOF ;
    public final EObject entryRuleExponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExponent = null;


        try {
            // InternalSephirah.g:1245:49: (iv_ruleExponent= ruleExponent EOF )
            // InternalSephirah.g:1246:2: iv_ruleExponent= ruleExponent EOF
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
    // InternalSephirah.g:1252:1: ruleExponent returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '^' ( (lv_right_3_0= ruleUnary ) ) )? ) ;
    public final EObject ruleExponent() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_PrimaryExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:1258:2: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '^' ( (lv_right_3_0= ruleUnary ) ) )? ) )
            // InternalSephirah.g:1259:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '^' ( (lv_right_3_0= ruleUnary ) ) )? )
            {
            // InternalSephirah.g:1259:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '^' ( (lv_right_3_0= ruleUnary ) ) )? )
            // InternalSephirah.g:1260:3: this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '^' ( (lv_right_3_0= ruleUnary ) ) )?
            {

            			newCompositeNode(grammarAccess.getExponentAccess().getPrimaryExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_20);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;


            			current = this_PrimaryExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSephirah.g:1268:3: ( () otherlv_2= '^' ( (lv_right_3_0= ruleUnary ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==33) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalSephirah.g:1269:4: () otherlv_2= '^' ( (lv_right_3_0= ruleUnary ) )
                    {
                    // InternalSephirah.g:1269:4: ()
                    // InternalSephirah.g:1270:5: 
                    {

                    					current = forceCreateModelElementAndSet(
                    						grammarAccess.getExponentAccess().getExponentLeftAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_2=(Token)match(input,33,FOLLOW_11); 

                    				newLeafNode(otherlv_2, grammarAccess.getExponentAccess().getCircumflexAccentKeyword_1_1());
                    			
                    // InternalSephirah.g:1280:4: ( (lv_right_3_0= ruleUnary ) )
                    // InternalSephirah.g:1281:5: (lv_right_3_0= ruleUnary )
                    {
                    // InternalSephirah.g:1281:5: (lv_right_3_0= ruleUnary )
                    // InternalSephirah.g:1282:6: lv_right_3_0= ruleUnary
                    {

                    						newCompositeNode(grammarAccess.getExponentAccess().getRightUnaryParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleUnary();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExponentRule());
                    						}
                    						set(
                    							current,
                    							"right",
                    							lv_right_3_0,
                    							"com.fearlesstyrant.sephirah.Sephirah.Unary");
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
    // InternalSephirah.g:1304:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalSephirah.g:1304:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalSephirah.g:1305:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalSephirah.g:1311:1: rulePrimaryExpression returns [EObject current=null] : ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= ruleDecimal ) ) ) | this_BooleanLiteral_5= ruleBooleanLiteral | this_MethodCall_6= ruleMethodCall | this_Constant_7= ruleConstant | this_Variable_8= ruleVariable ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Expression_1 = null;

        AntlrDatatypeRuleToken lv_value_4_0 = null;

        EObject this_BooleanLiteral_5 = null;

        EObject this_MethodCall_6 = null;

        EObject this_Constant_7 = null;

        EObject this_Variable_8 = null;



        	enterRule();

        try {
            // InternalSephirah.g:1317:2: ( ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= ruleDecimal ) ) ) | this_BooleanLiteral_5= ruleBooleanLiteral | this_MethodCall_6= ruleMethodCall | this_Constant_7= ruleConstant | this_Variable_8= ruleVariable ) )
            // InternalSephirah.g:1318:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= ruleDecimal ) ) ) | this_BooleanLiteral_5= ruleBooleanLiteral | this_MethodCall_6= ruleMethodCall | this_Constant_7= ruleConstant | this_Variable_8= ruleVariable )
            {
            // InternalSephirah.g:1318:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= ruleDecimal ) ) ) | this_BooleanLiteral_5= ruleBooleanLiteral | this_MethodCall_6= ruleMethodCall | this_Constant_7= ruleConstant | this_Variable_8= ruleVariable )
            int alt18=6;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // InternalSephirah.g:1319:3: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    {
                    // InternalSephirah.g:1319:3: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    // InternalSephirah.g:1320:4: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,16,FOLLOW_11); 

                    				newLeafNode(otherlv_0, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_0());
                    			

                    				newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_21);
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
                    // InternalSephirah.g:1338:3: ( () ( (lv_value_4_0= ruleDecimal ) ) )
                    {
                    // InternalSephirah.g:1338:3: ( () ( (lv_value_4_0= ruleDecimal ) ) )
                    // InternalSephirah.g:1339:4: () ( (lv_value_4_0= ruleDecimal ) )
                    {
                    // InternalSephirah.g:1339:4: ()
                    // InternalSephirah.g:1340:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimaryExpressionAccess().getNumberLiteralAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSephirah.g:1346:4: ( (lv_value_4_0= ruleDecimal ) )
                    // InternalSephirah.g:1347:5: (lv_value_4_0= ruleDecimal )
                    {
                    // InternalSephirah.g:1347:5: (lv_value_4_0= ruleDecimal )
                    // InternalSephirah.g:1348:6: lv_value_4_0= ruleDecimal
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
                    // InternalSephirah.g:1367:3: this_BooleanLiteral_5= ruleBooleanLiteral
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getBooleanLiteralParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_BooleanLiteral_5=ruleBooleanLiteral();

                    state._fsp--;


                    			current = this_BooleanLiteral_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalSephirah.g:1376:3: this_MethodCall_6= ruleMethodCall
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getMethodCallParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_MethodCall_6=ruleMethodCall();

                    state._fsp--;


                    			current = this_MethodCall_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalSephirah.g:1385:3: this_Constant_7= ruleConstant
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getConstantParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Constant_7=ruleConstant();

                    state._fsp--;


                    			current = this_Constant_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalSephirah.g:1394:3: this_Variable_8= ruleVariable
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getVariableParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Variable_8=ruleVariable();

                    state._fsp--;


                    			current = this_Variable_8;
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


    // $ANTLR start "entryRuleBooleanLiteral"
    // InternalSephirah.g:1406:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalSephirah.g:1406:55: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalSephirah.g:1407:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;

             current =iv_ruleBooleanLiteral; 
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
    // $ANTLR end "entryRuleBooleanLiteral"


    // $ANTLR start "ruleBooleanLiteral"
    // InternalSephirah.g:1413:1: ruleBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_1= 'true' | lv_value_1_2= 'false' ) ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_1=null;
        Token lv_value_1_2=null;


        	enterRule();

        try {
            // InternalSephirah.g:1419:2: ( ( () ( ( (lv_value_1_1= 'true' | lv_value_1_2= 'false' ) ) ) ) )
            // InternalSephirah.g:1420:2: ( () ( ( (lv_value_1_1= 'true' | lv_value_1_2= 'false' ) ) ) )
            {
            // InternalSephirah.g:1420:2: ( () ( ( (lv_value_1_1= 'true' | lv_value_1_2= 'false' ) ) ) )
            // InternalSephirah.g:1421:3: () ( ( (lv_value_1_1= 'true' | lv_value_1_2= 'false' ) ) )
            {
            // InternalSephirah.g:1421:3: ()
            // InternalSephirah.g:1422:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
            					current);
            			

            }

            // InternalSephirah.g:1428:3: ( ( (lv_value_1_1= 'true' | lv_value_1_2= 'false' ) ) )
            // InternalSephirah.g:1429:4: ( (lv_value_1_1= 'true' | lv_value_1_2= 'false' ) )
            {
            // InternalSephirah.g:1429:4: ( (lv_value_1_1= 'true' | lv_value_1_2= 'false' ) )
            // InternalSephirah.g:1430:5: (lv_value_1_1= 'true' | lv_value_1_2= 'false' )
            {
            // InternalSephirah.g:1430:5: (lv_value_1_1= 'true' | lv_value_1_2= 'false' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==34) ) {
                alt19=1;
            }
            else if ( (LA19_0==35) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalSephirah.g:1431:6: lv_value_1_1= 'true'
                    {
                    lv_value_1_1=(Token)match(input,34,FOLLOW_2); 

                    						newLeafNode(lv_value_1_1, grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBooleanLiteralRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalSephirah.g:1442:6: lv_value_1_2= 'false'
                    {
                    lv_value_1_2=(Token)match(input,35,FOLLOW_2); 

                    						newLeafNode(lv_value_1_2, grammarAccess.getBooleanLiteralAccess().getValueFalseKeyword_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBooleanLiteralRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_2, null);
                    					

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
    // $ANTLR end "ruleBooleanLiteral"


    // $ANTLR start "entryRuleMethodCall"
    // InternalSephirah.g:1459:1: entryRuleMethodCall returns [EObject current=null] : iv_ruleMethodCall= ruleMethodCall EOF ;
    public final EObject entryRuleMethodCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodCall = null;


        try {
            // InternalSephirah.g:1459:51: (iv_ruleMethodCall= ruleMethodCall EOF )
            // InternalSephirah.g:1460:2: iv_ruleMethodCall= ruleMethodCall EOF
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
    // InternalSephirah.g:1466:1: ruleMethodCall returns [EObject current=null] : ( () ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) ;
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
            // InternalSephirah.g:1472:2: ( ( () ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) )
            // InternalSephirah.g:1473:2: ( () ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            {
            // InternalSephirah.g:1473:2: ( () ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            // InternalSephirah.g:1474:3: () ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')'
            {
            // InternalSephirah.g:1474:3: ()
            // InternalSephirah.g:1475:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMethodCallAccess().getMethodCallAction_0(),
            					current);
            			

            }

            // InternalSephirah.g:1481:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalSephirah.g:1482:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalSephirah.g:1482:4: (lv_name_1_0= ruleQualifiedName )
            // InternalSephirah.g:1483:5: lv_name_1_0= ruleQualifiedName
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

            otherlv_2=(Token)match(input,16,FOLLOW_22); 

            			newLeafNode(otherlv_2, grammarAccess.getMethodCallAccess().getLeftParenthesisKeyword_2());
            		
            // InternalSephirah.g:1504:3: ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_ID && LA21_0<=RULE_INT)||LA21_0==16||LA21_0==21||(LA21_0>=26 && LA21_0<=27)||LA21_0==30||(LA21_0>=34 && LA21_0<=40)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalSephirah.g:1505:4: ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    {
                    // InternalSephirah.g:1505:4: ( (lv_args_3_0= ruleExpression ) )
                    // InternalSephirah.g:1506:5: (lv_args_3_0= ruleExpression )
                    {
                    // InternalSephirah.g:1506:5: (lv_args_3_0= ruleExpression )
                    // InternalSephirah.g:1507:6: lv_args_3_0= ruleExpression
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

                    // InternalSephirah.g:1524:4: (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==17) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalSephirah.g:1525:5: otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,17,FOLLOW_11); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getMethodCallAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalSephirah.g:1529:5: ( (lv_args_5_0= ruleExpression ) )
                    	    // InternalSephirah.g:1530:6: (lv_args_5_0= ruleExpression )
                    	    {
                    	    // InternalSephirah.g:1530:6: (lv_args_5_0= ruleExpression )
                    	    // InternalSephirah.g:1531:7: lv_args_5_0= ruleExpression
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
                    	    break loop20;
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
    // InternalSephirah.g:1558:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalSephirah.g:1558:49: (iv_ruleConstant= ruleConstant EOF )
            // InternalSephirah.g:1559:2: iv_ruleConstant= ruleConstant EOF
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
    // InternalSephirah.g:1565:1: ruleConstant returns [EObject current=null] : ( () ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) ) ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_1=null;
        Token lv_value_1_2=null;
        Token lv_value_1_3=null;
        Token lv_value_1_4=null;
        Token lv_value_1_5=null;


        	enterRule();

        try {
            // InternalSephirah.g:1571:2: ( ( () ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) ) ) )
            // InternalSephirah.g:1572:2: ( () ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) ) )
            {
            // InternalSephirah.g:1572:2: ( () ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) ) )
            // InternalSephirah.g:1573:3: () ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) )
            {
            // InternalSephirah.g:1573:3: ()
            // InternalSephirah.g:1574:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getConstantAccess().getConstantAction_0(),
            					current);
            			

            }

            // InternalSephirah.g:1580:3: ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) )
            // InternalSephirah.g:1581:4: ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) )
            {
            // InternalSephirah.g:1581:4: ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) )
            // InternalSephirah.g:1582:5: (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' )
            {
            // InternalSephirah.g:1582:5: (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' )
            int alt22=5;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt22=1;
                }
                break;
            case 37:
                {
                alt22=2;
                }
                break;
            case 38:
                {
                alt22=3;
                }
                break;
            case 39:
                {
                alt22=4;
                }
                break;
            case 40:
                {
                alt22=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalSephirah.g:1583:6: lv_value_1_1= 'pi'
                    {
                    lv_value_1_1=(Token)match(input,36,FOLLOW_2); 

                    						newLeafNode(lv_value_1_1, grammarAccess.getConstantAccess().getValuePiKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstantRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalSephirah.g:1594:6: lv_value_1_2= 'G'
                    {
                    lv_value_1_2=(Token)match(input,37,FOLLOW_2); 

                    						newLeafNode(lv_value_1_2, grammarAccess.getConstantAccess().getValueGKeyword_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstantRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalSephirah.g:1605:6: lv_value_1_3= 'phi'
                    {
                    lv_value_1_3=(Token)match(input,38,FOLLOW_2); 

                    						newLeafNode(lv_value_1_3, grammarAccess.getConstantAccess().getValuePhiKeyword_1_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstantRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_3, null);
                    					

                    }
                    break;
                case 4 :
                    // InternalSephirah.g:1616:6: lv_value_1_4= 'gamma'
                    {
                    lv_value_1_4=(Token)match(input,39,FOLLOW_2); 

                    						newLeafNode(lv_value_1_4, grammarAccess.getConstantAccess().getValueGammaKeyword_1_0_3());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstantRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_4, null);
                    					

                    }
                    break;
                case 5 :
                    // InternalSephirah.g:1627:6: lv_value_1_5= 'e'
                    {
                    lv_value_1_5=(Token)match(input,40,FOLLOW_2); 

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
    // InternalSephirah.g:1644:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalSephirah.g:1644:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalSephirah.g:1645:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalSephirah.g:1651:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;



        	enterRule();

        try {
            // InternalSephirah.g:1657:2: ( (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* ) )
            // InternalSephirah.g:1658:2: (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* )
            {
            // InternalSephirah.g:1658:2: (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* )
            // InternalSephirah.g:1659:3: this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )*
            {

            			newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0());
            		
            pushFollow(FOLLOW_23);
            this_ValidID_0=ruleValidID();

            state._fsp--;


            			current.merge(this_ValidID_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalSephirah.g:1669:3: (kw= '.' this_ValidID_2= ruleValidID )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==41) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalSephirah.g:1670:4: kw= '.' this_ValidID_2= ruleValidID
            	    {
            	    kw=(Token)match(input,41,FOLLOW_5); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			

            	    				newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1());
            	    			
            	    pushFollow(FOLLOW_23);
            	    this_ValidID_2=ruleValidID();

            	    state._fsp--;


            	    				current.merge(this_ValidID_2);
            	    			

            	    				afterParserOrEnumRuleCall();
            	    			

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // InternalSephirah.g:1690:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // InternalSephirah.g:1690:47: (iv_ruleValidID= ruleValidID EOF )
            // InternalSephirah.g:1691:2: iv_ruleValidID= ruleValidID EOF
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
    // InternalSephirah.g:1697:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_ESCAPED_ID_1=null;


        	enterRule();

        try {
            // InternalSephirah.g:1703:2: ( (this_ID_0= RULE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) )
            // InternalSephirah.g:1704:2: (this_ID_0= RULE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            {
            // InternalSephirah.g:1704:2: (this_ID_0= RULE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID) ) {
                alt24=1;
            }
            else if ( (LA24_0==RULE_ESCAPED_ID) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalSephirah.g:1705:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_0);
                    		

                    			newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSephirah.g:1713:3: this_ESCAPED_ID_1= RULE_ESCAPED_ID
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
    // InternalSephirah.g:1724:1: entryRuleDecimal returns [String current=null] : iv_ruleDecimal= ruleDecimal EOF ;
    public final String entryRuleDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimal = null;


        try {
            // InternalSephirah.g:1724:47: (iv_ruleDecimal= ruleDecimal EOF )
            // InternalSephirah.g:1725:2: iv_ruleDecimal= ruleDecimal EOF
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
    // InternalSephirah.g:1731:1: ruleDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalSephirah.g:1737:2: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) )
            // InternalSephirah.g:1738:2: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            {
            // InternalSephirah.g:1738:2: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            // InternalSephirah.g:1739:3: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )?
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_23); 

            			current.merge(this_INT_0);
            		

            			newLeafNode(this_INT_0, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_0());
            		
            // InternalSephirah.g:1746:3: (kw= '.' this_INT_2= RULE_INT )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==41) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalSephirah.g:1747:4: kw= '.' this_INT_2= RULE_INT
                    {
                    kw=(Token)match(input,41,FOLLOW_24); 

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


    // $ANTLR start "ruleComparisonOperator"
    // InternalSephirah.g:1764:1: ruleComparisonOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<=' ) | (enumLiteral_1= '>=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '>' ) ) ;
    public final Enumerator ruleComparisonOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalSephirah.g:1770:2: ( ( (enumLiteral_0= '<=' ) | (enumLiteral_1= '>=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '>' ) ) )
            // InternalSephirah.g:1771:2: ( (enumLiteral_0= '<=' ) | (enumLiteral_1= '>=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '>' ) )
            {
            // InternalSephirah.g:1771:2: ( (enumLiteral_0= '<=' ) | (enumLiteral_1= '>=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '>' ) )
            int alt26=6;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt26=1;
                }
                break;
            case 43:
                {
                alt26=2;
                }
                break;
            case 44:
                {
                alt26=3;
                }
                break;
            case 45:
                {
                alt26=4;
                }
                break;
            case 46:
                {
                alt26=5;
                }
                break;
            case 47:
                {
                alt26=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // InternalSephirah.g:1772:3: (enumLiteral_0= '<=' )
                    {
                    // InternalSephirah.g:1772:3: (enumLiteral_0= '<=' )
                    // InternalSephirah.g:1773:4: enumLiteral_0= '<='
                    {
                    enumLiteral_0=(Token)match(input,42,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorAccess().getLTEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getComparisonOperatorAccess().getLTEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSephirah.g:1780:3: (enumLiteral_1= '>=' )
                    {
                    // InternalSephirah.g:1780:3: (enumLiteral_1= '>=' )
                    // InternalSephirah.g:1781:4: enumLiteral_1= '>='
                    {
                    enumLiteral_1=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorAccess().getGTEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getComparisonOperatorAccess().getGTEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSephirah.g:1788:3: (enumLiteral_2= '==' )
                    {
                    // InternalSephirah.g:1788:3: (enumLiteral_2= '==' )
                    // InternalSephirah.g:1789:4: enumLiteral_2= '=='
                    {
                    enumLiteral_2=(Token)match(input,44,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorAccess().getEQEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getComparisonOperatorAccess().getEQEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSephirah.g:1796:3: (enumLiteral_3= '!=' )
                    {
                    // InternalSephirah.g:1796:3: (enumLiteral_3= '!=' )
                    // InternalSephirah.g:1797:4: enumLiteral_3= '!='
                    {
                    enumLiteral_3=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorAccess().getNEQEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getComparisonOperatorAccess().getNEQEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalSephirah.g:1804:3: (enumLiteral_4= '<' )
                    {
                    // InternalSephirah.g:1804:3: (enumLiteral_4= '<' )
                    // InternalSephirah.g:1805:4: enumLiteral_4= '<'
                    {
                    enumLiteral_4=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorAccess().getLTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getComparisonOperatorAccess().getLTEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalSephirah.g:1812:3: (enumLiteral_5= '>' )
                    {
                    // InternalSephirah.g:1812:3: (enumLiteral_5= '>' )
                    // InternalSephirah.g:1813:4: enumLiteral_5= '>'
                    {
                    enumLiteral_5=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorAccess().getGTEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getComparisonOperatorAccess().getGTEnumLiteralDeclaration_5());
                    			

                    }


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
    // $ANTLR end "ruleComparisonOperator"

    // Delegated rules


    protected DFA18 dfa18 = new DFA18(this);
    static final String dfa_1s = "\14\uffff";
    static final String dfa_2s = "\4\uffff\2\11\4\uffff\2\11";
    static final String dfa_3s = "\1\4\3\uffff\2\16\1\uffff\1\4\2\uffff\2\16";
    static final String dfa_4s = "\1\50\3\uffff\2\57\1\uffff\1\5\2\uffff\2\57";
    static final String dfa_5s = "\1\uffff\1\1\1\2\1\3\2\uffff\1\5\1\uffff\1\4\1\6\2\uffff";
    static final String dfa_6s = "\14\uffff}>";
    static final String[] dfa_7s = {
            "\1\4\1\5\1\2\11\uffff\1\1\21\uffff\2\3\5\6",
            "",
            "",
            "",
            "\1\11\1\uffff\1\10\2\11\3\uffff\4\11\2\uffff\6\11\7\uffff\1\7\6\11",
            "\1\11\1\uffff\1\10\2\11\3\uffff\4\11\2\uffff\6\11\7\uffff\1\7\6\11",
            "",
            "\1\12\1\13",
            "",
            "",
            "\1\11\1\uffff\1\10\2\11\3\uffff\4\11\2\uffff\6\11\7\uffff\1\7\6\11",
            "\1\11\1\uffff\1\10\2\11\3\uffff\4\11\2\uffff\6\11\7\uffff\1\7\6\11"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1318:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= ruleDecimal ) ) ) | this_BooleanLiteral_5= ruleBooleanLiteral | this_MethodCall_6= ruleMethodCall | this_Constant_7= ruleConstant | this_Variable_8= ruleVariable )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000001FC4C31A072L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000001FC4C318072L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000040030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x000001FC4C318070L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000FC0000000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x000001FC4C358070L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000040L});

}