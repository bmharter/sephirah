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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_ESCAPED_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'SephirahDoc'", "'import'", "';'", "'def'", "'('", "','", "')'", "'='", "'var'", "'if'", "'then'", "'else'", "'+'", "'-'", "'*'", "'/'", "'^'", "'or'", "'and'", "'not'", "'pi'", "'G'", "'phi'", "'gamma'", "'e'", "'.'", "'<='", "'>='", "'=='", "'!='", "'<'", "'>'"
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
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
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
    // InternalSephirah.g:609:1: ruleExpression returns [EObject current=null] : this_Conditional_0= ruleConditional ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Conditional_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:615:2: (this_Conditional_0= ruleConditional )
            // InternalSephirah.g:616:2: this_Conditional_0= ruleConditional
            {

            		newCompositeNode(grammarAccess.getExpressionAccess().getConditionalParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_Conditional_0=ruleConditional();

            state._fsp--;


            		current = this_Conditional_0;
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


    // $ANTLR start "entryRuleConditional"
    // InternalSephirah.g:627:1: entryRuleConditional returns [EObject current=null] : iv_ruleConditional= ruleConditional EOF ;
    public final EObject entryRuleConditional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditional = null;


        try {
            // InternalSephirah.g:627:52: (iv_ruleConditional= ruleConditional EOF )
            // InternalSephirah.g:628:2: iv_ruleConditional= ruleConditional EOF
            {
             newCompositeNode(grammarAccess.getConditionalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConditional=ruleConditional();

            state._fsp--;

             current =iv_ruleConditional; 
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
    // $ANTLR end "entryRuleConditional"


    // $ANTLR start "ruleConditional"
    // InternalSephirah.g:634:1: ruleConditional returns [EObject current=null] : ( ( () otherlv_1= 'if' ( (lv_condition_2_0= ruleCondition ) ) otherlv_3= 'then' ( (lv_thenBranch_4_0= ruleExpression ) ) otherlv_5= 'else' ( (lv_elseBranch_6_0= ruleExpression ) ) ) | this_Addition_7= ruleAddition ) ;
    public final EObject ruleConditional() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_condition_2_0 = null;

        EObject lv_thenBranch_4_0 = null;

        EObject lv_elseBranch_6_0 = null;

        EObject this_Addition_7 = null;



        	enterRule();

        try {
            // InternalSephirah.g:640:2: ( ( ( () otherlv_1= 'if' ( (lv_condition_2_0= ruleCondition ) ) otherlv_3= 'then' ( (lv_thenBranch_4_0= ruleExpression ) ) otherlv_5= 'else' ( (lv_elseBranch_6_0= ruleExpression ) ) ) | this_Addition_7= ruleAddition ) )
            // InternalSephirah.g:641:2: ( ( () otherlv_1= 'if' ( (lv_condition_2_0= ruleCondition ) ) otherlv_3= 'then' ( (lv_thenBranch_4_0= ruleExpression ) ) otherlv_5= 'else' ( (lv_elseBranch_6_0= ruleExpression ) ) ) | this_Addition_7= ruleAddition )
            {
            // InternalSephirah.g:641:2: ( ( () otherlv_1= 'if' ( (lv_condition_2_0= ruleCondition ) ) otherlv_3= 'then' ( (lv_thenBranch_4_0= ruleExpression ) ) otherlv_5= 'else' ( (lv_elseBranch_6_0= ruleExpression ) ) ) | this_Addition_7= ruleAddition )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==21) ) {
                alt6=1;
            }
            else if ( ((LA6_0>=RULE_ID && LA6_0<=RULE_INT)||LA6_0==16||(LA6_0>=32 && LA6_0<=36)) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalSephirah.g:642:3: ( () otherlv_1= 'if' ( (lv_condition_2_0= ruleCondition ) ) otherlv_3= 'then' ( (lv_thenBranch_4_0= ruleExpression ) ) otherlv_5= 'else' ( (lv_elseBranch_6_0= ruleExpression ) ) )
                    {
                    // InternalSephirah.g:642:3: ( () otherlv_1= 'if' ( (lv_condition_2_0= ruleCondition ) ) otherlv_3= 'then' ( (lv_thenBranch_4_0= ruleExpression ) ) otherlv_5= 'else' ( (lv_elseBranch_6_0= ruleExpression ) ) )
                    // InternalSephirah.g:643:4: () otherlv_1= 'if' ( (lv_condition_2_0= ruleCondition ) ) otherlv_3= 'then' ( (lv_thenBranch_4_0= ruleExpression ) ) otherlv_5= 'else' ( (lv_elseBranch_6_0= ruleExpression ) )
                    {
                    // InternalSephirah.g:643:4: ()
                    // InternalSephirah.g:644:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getConditionalAccess().getConditionalAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,21,FOLLOW_12); 

                    				newLeafNode(otherlv_1, grammarAccess.getConditionalAccess().getIfKeyword_0_1());
                    			
                    // InternalSephirah.g:654:4: ( (lv_condition_2_0= ruleCondition ) )
                    // InternalSephirah.g:655:5: (lv_condition_2_0= ruleCondition )
                    {
                    // InternalSephirah.g:655:5: (lv_condition_2_0= ruleCondition )
                    // InternalSephirah.g:656:6: lv_condition_2_0= ruleCondition
                    {

                    						newCompositeNode(grammarAccess.getConditionalAccess().getConditionConditionParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_condition_2_0=ruleCondition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConditionalRule());
                    						}
                    						set(
                    							current,
                    							"condition",
                    							lv_condition_2_0,
                    							"com.fearlesstyrant.sephirah.Sephirah.Condition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,22,FOLLOW_11); 

                    				newLeafNode(otherlv_3, grammarAccess.getConditionalAccess().getThenKeyword_0_3());
                    			
                    // InternalSephirah.g:677:4: ( (lv_thenBranch_4_0= ruleExpression ) )
                    // InternalSephirah.g:678:5: (lv_thenBranch_4_0= ruleExpression )
                    {
                    // InternalSephirah.g:678:5: (lv_thenBranch_4_0= ruleExpression )
                    // InternalSephirah.g:679:6: lv_thenBranch_4_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getConditionalAccess().getThenBranchExpressionParserRuleCall_0_4_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_thenBranch_4_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConditionalRule());
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

                    				newLeafNode(otherlv_5, grammarAccess.getConditionalAccess().getElseKeyword_0_5());
                    			
                    // InternalSephirah.g:700:4: ( (lv_elseBranch_6_0= ruleExpression ) )
                    // InternalSephirah.g:701:5: (lv_elseBranch_6_0= ruleExpression )
                    {
                    // InternalSephirah.g:701:5: (lv_elseBranch_6_0= ruleExpression )
                    // InternalSephirah.g:702:6: lv_elseBranch_6_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getConditionalAccess().getElseBranchExpressionParserRuleCall_0_6_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_elseBranch_6_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConditionalRule());
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
                    // InternalSephirah.g:721:3: this_Addition_7= ruleAddition
                    {

                    			newCompositeNode(grammarAccess.getConditionalAccess().getAdditionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Addition_7=ruleAddition();

                    state._fsp--;


                    			current = this_Addition_7;
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
    // $ANTLR end "ruleConditional"


    // $ANTLR start "entryRuleAddition"
    // InternalSephirah.g:733:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // InternalSephirah.g:733:49: (iv_ruleAddition= ruleAddition EOF )
            // InternalSephirah.g:734:2: iv_ruleAddition= ruleAddition EOF
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
    // InternalSephirah.g:740:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:746:2: ( (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) )
            // InternalSephirah.g:747:2: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            {
            // InternalSephirah.g:747:2: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            // InternalSephirah.g:748:3: this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            {

            			newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0());
            		
            pushFollow(FOLLOW_15);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;


            			current = this_Multiplication_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSephirah.g:756:3: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=24 && LA8_0<=25)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalSephirah.g:757:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) )
            	    {
            	    // InternalSephirah.g:757:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt7=2;
            	    int LA7_0 = input.LA(1);

            	    if ( (LA7_0==24) ) {
            	        alt7=1;
            	    }
            	    else if ( (LA7_0==25) ) {
            	        alt7=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 7, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt7) {
            	        case 1 :
            	            // InternalSephirah.g:758:5: ( () otherlv_2= '+' )
            	            {
            	            // InternalSephirah.g:758:5: ( () otherlv_2= '+' )
            	            // InternalSephirah.g:759:6: () otherlv_2= '+'
            	            {
            	            // InternalSephirah.g:759:6: ()
            	            // InternalSephirah.g:760:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getAdditionAccess().getAddLeftAction_1_0_0_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_2=(Token)match(input,24,FOLLOW_11); 

            	            						newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalSephirah.g:772:5: ( () otherlv_4= '-' )
            	            {
            	            // InternalSephirah.g:772:5: ( () otherlv_4= '-' )
            	            // InternalSephirah.g:773:6: () otherlv_4= '-'
            	            {
            	            // InternalSephirah.g:773:6: ()
            	            // InternalSephirah.g:774:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getAdditionAccess().getSubtractLeftAction_1_0_1_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_4=(Token)match(input,25,FOLLOW_11); 

            	            						newLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalSephirah.g:786:4: ( (lv_right_5_0= ruleMultiplication ) )
            	    // InternalSephirah.g:787:5: (lv_right_5_0= ruleMultiplication )
            	    {
            	    // InternalSephirah.g:787:5: (lv_right_5_0= ruleMultiplication )
            	    // InternalSephirah.g:788:6: lv_right_5_0= ruleMultiplication
            	    {

            	    						newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_15);
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
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleMultiplication"
    // InternalSephirah.g:810:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // InternalSephirah.g:810:55: (iv_ruleMultiplication= ruleMultiplication EOF )
            // InternalSephirah.g:811:2: iv_ruleMultiplication= ruleMultiplication EOF
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
    // InternalSephirah.g:817:1: ruleMultiplication returns [EObject current=null] : (this_Exponent_0= ruleExponent ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleExponent ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Exponent_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:823:2: ( (this_Exponent_0= ruleExponent ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleExponent ) ) )* ) )
            // InternalSephirah.g:824:2: (this_Exponent_0= ruleExponent ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleExponent ) ) )* )
            {
            // InternalSephirah.g:824:2: (this_Exponent_0= ruleExponent ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleExponent ) ) )* )
            // InternalSephirah.g:825:3: this_Exponent_0= ruleExponent ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleExponent ) ) )*
            {

            			newCompositeNode(grammarAccess.getMultiplicationAccess().getExponentParserRuleCall_0());
            		
            pushFollow(FOLLOW_16);
            this_Exponent_0=ruleExponent();

            state._fsp--;


            			current = this_Exponent_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSephirah.g:833:3: ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleExponent ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=26 && LA10_0<=27)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalSephirah.g:834:4: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleExponent ) )
            	    {
            	    // InternalSephirah.g:834:4: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) )
            	    int alt9=2;
            	    int LA9_0 = input.LA(1);

            	    if ( (LA9_0==26) ) {
            	        alt9=1;
            	    }
            	    else if ( (LA9_0==27) ) {
            	        alt9=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 9, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt9) {
            	        case 1 :
            	            // InternalSephirah.g:835:5: ( () otherlv_2= '*' )
            	            {
            	            // InternalSephirah.g:835:5: ( () otherlv_2= '*' )
            	            // InternalSephirah.g:836:6: () otherlv_2= '*'
            	            {
            	            // InternalSephirah.g:836:6: ()
            	            // InternalSephirah.g:837:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getMultiplicationAccess().getMultiplyLeftAction_1_0_0_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_2=(Token)match(input,26,FOLLOW_11); 

            	            						newLeafNode(otherlv_2, grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalSephirah.g:849:5: ( () otherlv_4= '/' )
            	            {
            	            // InternalSephirah.g:849:5: ( () otherlv_4= '/' )
            	            // InternalSephirah.g:850:6: () otherlv_4= '/'
            	            {
            	            // InternalSephirah.g:850:6: ()
            	            // InternalSephirah.g:851:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getMultiplicationAccess().getDivideLeftAction_1_0_1_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_4=(Token)match(input,27,FOLLOW_11); 

            	            						newLeafNode(otherlv_4, grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_0_1_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalSephirah.g:863:4: ( (lv_right_5_0= ruleExponent ) )
            	    // InternalSephirah.g:864:5: (lv_right_5_0= ruleExponent )
            	    {
            	    // InternalSephirah.g:864:5: (lv_right_5_0= ruleExponent )
            	    // InternalSephirah.g:865:6: lv_right_5_0= ruleExponent
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplicationAccess().getRightExponentParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_16);
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
            	    break loop10;
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
    // InternalSephirah.g:887:1: entryRuleExponent returns [EObject current=null] : iv_ruleExponent= ruleExponent EOF ;
    public final EObject entryRuleExponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExponent = null;


        try {
            // InternalSephirah.g:887:49: (iv_ruleExponent= ruleExponent EOF )
            // InternalSephirah.g:888:2: iv_ruleExponent= ruleExponent EOF
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
    // InternalSephirah.g:894:1: ruleExponent returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '^' ( (lv_right_3_0= ruleExponent ) ) )? ) ;
    public final EObject ruleExponent() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_PrimaryExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:900:2: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '^' ( (lv_right_3_0= ruleExponent ) ) )? ) )
            // InternalSephirah.g:901:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '^' ( (lv_right_3_0= ruleExponent ) ) )? )
            {
            // InternalSephirah.g:901:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '^' ( (lv_right_3_0= ruleExponent ) ) )? )
            // InternalSephirah.g:902:3: this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '^' ( (lv_right_3_0= ruleExponent ) ) )?
            {

            			newCompositeNode(grammarAccess.getExponentAccess().getPrimaryExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_17);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;


            			current = this_PrimaryExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSephirah.g:910:3: ( () otherlv_2= '^' ( (lv_right_3_0= ruleExponent ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==28) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalSephirah.g:911:4: () otherlv_2= '^' ( (lv_right_3_0= ruleExponent ) )
                    {
                    // InternalSephirah.g:911:4: ()
                    // InternalSephirah.g:912:5: 
                    {

                    					current = forceCreateModelElementAndSet(
                    						grammarAccess.getExponentAccess().getExponentLeftAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_2=(Token)match(input,28,FOLLOW_11); 

                    				newLeafNode(otherlv_2, grammarAccess.getExponentAccess().getCircumflexAccentKeyword_1_1());
                    			
                    // InternalSephirah.g:922:4: ( (lv_right_3_0= ruleExponent ) )
                    // InternalSephirah.g:923:5: (lv_right_3_0= ruleExponent )
                    {
                    // InternalSephirah.g:923:5: (lv_right_3_0= ruleExponent )
                    // InternalSephirah.g:924:6: lv_right_3_0= ruleExponent
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
    // InternalSephirah.g:946:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalSephirah.g:946:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalSephirah.g:947:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalSephirah.g:953:1: rulePrimaryExpression returns [EObject current=null] : ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= ruleDecimal ) ) ) | this_MethodCall_5= ruleMethodCall | this_Constant_6= ruleConstant | this_Variable_7= ruleVariable ) ;
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
            // InternalSephirah.g:959:2: ( ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= ruleDecimal ) ) ) | this_MethodCall_5= ruleMethodCall | this_Constant_6= ruleConstant | this_Variable_7= ruleVariable ) )
            // InternalSephirah.g:960:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= ruleDecimal ) ) ) | this_MethodCall_5= ruleMethodCall | this_Constant_6= ruleConstant | this_Variable_7= ruleVariable )
            {
            // InternalSephirah.g:960:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= ruleDecimal ) ) ) | this_MethodCall_5= ruleMethodCall | this_Constant_6= ruleConstant | this_Variable_7= ruleVariable )
            int alt12=5;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // InternalSephirah.g:961:3: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    {
                    // InternalSephirah.g:961:3: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    // InternalSephirah.g:962:4: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,16,FOLLOW_11); 

                    				newLeafNode(otherlv_0, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_0());
                    			

                    				newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_18);
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
                    // InternalSephirah.g:980:3: ( () ( (lv_value_4_0= ruleDecimal ) ) )
                    {
                    // InternalSephirah.g:980:3: ( () ( (lv_value_4_0= ruleDecimal ) ) )
                    // InternalSephirah.g:981:4: () ( (lv_value_4_0= ruleDecimal ) )
                    {
                    // InternalSephirah.g:981:4: ()
                    // InternalSephirah.g:982:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimaryExpressionAccess().getNumberLiteralAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSephirah.g:988:4: ( (lv_value_4_0= ruleDecimal ) )
                    // InternalSephirah.g:989:5: (lv_value_4_0= ruleDecimal )
                    {
                    // InternalSephirah.g:989:5: (lv_value_4_0= ruleDecimal )
                    // InternalSephirah.g:990:6: lv_value_4_0= ruleDecimal
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
                    // InternalSephirah.g:1009:3: this_MethodCall_5= ruleMethodCall
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
                    // InternalSephirah.g:1018:3: this_Constant_6= ruleConstant
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
                    // InternalSephirah.g:1027:3: this_Variable_7= ruleVariable
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


    // $ANTLR start "entryRuleCondition"
    // InternalSephirah.g:1039:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // InternalSephirah.g:1039:50: (iv_ruleCondition= ruleCondition EOF )
            // InternalSephirah.g:1040:2: iv_ruleCondition= ruleCondition EOF
            {
             newCompositeNode(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCondition=ruleCondition();

            state._fsp--;

             current =iv_ruleCondition; 
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
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalSephirah.g:1046:1: ruleCondition returns [EObject current=null] : this_OrCondition_0= ruleOrCondition ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        EObject this_OrCondition_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:1052:2: (this_OrCondition_0= ruleOrCondition )
            // InternalSephirah.g:1053:2: this_OrCondition_0= ruleOrCondition
            {

            		newCompositeNode(grammarAccess.getConditionAccess().getOrConditionParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_OrCondition_0=ruleOrCondition();

            state._fsp--;


            		current = this_OrCondition_0;
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
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleOrCondition"
    // InternalSephirah.g:1064:1: entryRuleOrCondition returns [EObject current=null] : iv_ruleOrCondition= ruleOrCondition EOF ;
    public final EObject entryRuleOrCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrCondition = null;


        try {
            // InternalSephirah.g:1064:52: (iv_ruleOrCondition= ruleOrCondition EOF )
            // InternalSephirah.g:1065:2: iv_ruleOrCondition= ruleOrCondition EOF
            {
             newCompositeNode(grammarAccess.getOrConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrCondition=ruleOrCondition();

            state._fsp--;

             current =iv_ruleOrCondition; 
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
    // $ANTLR end "entryRuleOrCondition"


    // $ANTLR start "ruleOrCondition"
    // InternalSephirah.g:1071:1: ruleOrCondition returns [EObject current=null] : (this_AndCondition_0= ruleAndCondition ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndCondition ) ) )* ) ;
    public final EObject ruleOrCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndCondition_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:1077:2: ( (this_AndCondition_0= ruleAndCondition ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndCondition ) ) )* ) )
            // InternalSephirah.g:1078:2: (this_AndCondition_0= ruleAndCondition ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndCondition ) ) )* )
            {
            // InternalSephirah.g:1078:2: (this_AndCondition_0= ruleAndCondition ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndCondition ) ) )* )
            // InternalSephirah.g:1079:3: this_AndCondition_0= ruleAndCondition ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndCondition ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrConditionAccess().getAndConditionParserRuleCall_0());
            		
            pushFollow(FOLLOW_19);
            this_AndCondition_0=ruleAndCondition();

            state._fsp--;


            			current = this_AndCondition_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSephirah.g:1087:3: ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndCondition ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==29) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalSephirah.g:1088:4: () otherlv_2= 'or' ( (lv_right_3_0= ruleAndCondition ) )
            	    {
            	    // InternalSephirah.g:1088:4: ()
            	    // InternalSephirah.g:1089:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getOrConditionAccess().getOrConditionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,29,FOLLOW_12); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOrConditionAccess().getOrKeyword_1_1());
            	    			
            	    // InternalSephirah.g:1099:4: ( (lv_right_3_0= ruleAndCondition ) )
            	    // InternalSephirah.g:1100:5: (lv_right_3_0= ruleAndCondition )
            	    {
            	    // InternalSephirah.g:1100:5: (lv_right_3_0= ruleAndCondition )
            	    // InternalSephirah.g:1101:6: lv_right_3_0= ruleAndCondition
            	    {

            	    						newCompositeNode(grammarAccess.getOrConditionAccess().getRightAndConditionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_19);
            	    lv_right_3_0=ruleAndCondition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOrConditionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"com.fearlesstyrant.sephirah.Sephirah.AndCondition");
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
    // $ANTLR end "ruleOrCondition"


    // $ANTLR start "entryRuleAndCondition"
    // InternalSephirah.g:1123:1: entryRuleAndCondition returns [EObject current=null] : iv_ruleAndCondition= ruleAndCondition EOF ;
    public final EObject entryRuleAndCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndCondition = null;


        try {
            // InternalSephirah.g:1123:53: (iv_ruleAndCondition= ruleAndCondition EOF )
            // InternalSephirah.g:1124:2: iv_ruleAndCondition= ruleAndCondition EOF
            {
             newCompositeNode(grammarAccess.getAndConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndCondition=ruleAndCondition();

            state._fsp--;

             current =iv_ruleAndCondition; 
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
    // $ANTLR end "entryRuleAndCondition"


    // $ANTLR start "ruleAndCondition"
    // InternalSephirah.g:1130:1: ruleAndCondition returns [EObject current=null] : (this_NotCondition_0= ruleNotCondition ( () otherlv_2= 'and' ( (lv_right_3_0= ruleNotCondition ) ) )* ) ;
    public final EObject ruleAndCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_NotCondition_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:1136:2: ( (this_NotCondition_0= ruleNotCondition ( () otherlv_2= 'and' ( (lv_right_3_0= ruleNotCondition ) ) )* ) )
            // InternalSephirah.g:1137:2: (this_NotCondition_0= ruleNotCondition ( () otherlv_2= 'and' ( (lv_right_3_0= ruleNotCondition ) ) )* )
            {
            // InternalSephirah.g:1137:2: (this_NotCondition_0= ruleNotCondition ( () otherlv_2= 'and' ( (lv_right_3_0= ruleNotCondition ) ) )* )
            // InternalSephirah.g:1138:3: this_NotCondition_0= ruleNotCondition ( () otherlv_2= 'and' ( (lv_right_3_0= ruleNotCondition ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndConditionAccess().getNotConditionParserRuleCall_0());
            		
            pushFollow(FOLLOW_20);
            this_NotCondition_0=ruleNotCondition();

            state._fsp--;


            			current = this_NotCondition_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSephirah.g:1146:3: ( () otherlv_2= 'and' ( (lv_right_3_0= ruleNotCondition ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==30) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalSephirah.g:1147:4: () otherlv_2= 'and' ( (lv_right_3_0= ruleNotCondition ) )
            	    {
            	    // InternalSephirah.g:1147:4: ()
            	    // InternalSephirah.g:1148:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndConditionAccess().getAndConditionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,30,FOLLOW_12); 

            	    				newLeafNode(otherlv_2, grammarAccess.getAndConditionAccess().getAndKeyword_1_1());
            	    			
            	    // InternalSephirah.g:1158:4: ( (lv_right_3_0= ruleNotCondition ) )
            	    // InternalSephirah.g:1159:5: (lv_right_3_0= ruleNotCondition )
            	    {
            	    // InternalSephirah.g:1159:5: (lv_right_3_0= ruleNotCondition )
            	    // InternalSephirah.g:1160:6: lv_right_3_0= ruleNotCondition
            	    {

            	    						newCompositeNode(grammarAccess.getAndConditionAccess().getRightNotConditionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_20);
            	    lv_right_3_0=ruleNotCondition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndConditionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"com.fearlesstyrant.sephirah.Sephirah.NotCondition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // $ANTLR end "ruleAndCondition"


    // $ANTLR start "entryRuleNotCondition"
    // InternalSephirah.g:1182:1: entryRuleNotCondition returns [EObject current=null] : iv_ruleNotCondition= ruleNotCondition EOF ;
    public final EObject entryRuleNotCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotCondition = null;


        try {
            // InternalSephirah.g:1182:53: (iv_ruleNotCondition= ruleNotCondition EOF )
            // InternalSephirah.g:1183:2: iv_ruleNotCondition= ruleNotCondition EOF
            {
             newCompositeNode(grammarAccess.getNotConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNotCondition=ruleNotCondition();

            state._fsp--;

             current =iv_ruleNotCondition; 
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
    // $ANTLR end "entryRuleNotCondition"


    // $ANTLR start "ruleNotCondition"
    // InternalSephirah.g:1189:1: ruleNotCondition returns [EObject current=null] : ( ( () otherlv_1= 'not' ( (lv_condition_2_0= ruleNotCondition ) ) ) | this_ComparisonCondition_3= ruleComparisonCondition ) ;
    public final EObject ruleNotCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_condition_2_0 = null;

        EObject this_ComparisonCondition_3 = null;



        	enterRule();

        try {
            // InternalSephirah.g:1195:2: ( ( ( () otherlv_1= 'not' ( (lv_condition_2_0= ruleNotCondition ) ) ) | this_ComparisonCondition_3= ruleComparisonCondition ) )
            // InternalSephirah.g:1196:2: ( ( () otherlv_1= 'not' ( (lv_condition_2_0= ruleNotCondition ) ) ) | this_ComparisonCondition_3= ruleComparisonCondition )
            {
            // InternalSephirah.g:1196:2: ( ( () otherlv_1= 'not' ( (lv_condition_2_0= ruleNotCondition ) ) ) | this_ComparisonCondition_3= ruleComparisonCondition )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==31) ) {
                alt15=1;
            }
            else if ( ((LA15_0>=RULE_ID && LA15_0<=RULE_INT)||LA15_0==16||(LA15_0>=32 && LA15_0<=36)) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalSephirah.g:1197:3: ( () otherlv_1= 'not' ( (lv_condition_2_0= ruleNotCondition ) ) )
                    {
                    // InternalSephirah.g:1197:3: ( () otherlv_1= 'not' ( (lv_condition_2_0= ruleNotCondition ) ) )
                    // InternalSephirah.g:1198:4: () otherlv_1= 'not' ( (lv_condition_2_0= ruleNotCondition ) )
                    {
                    // InternalSephirah.g:1198:4: ()
                    // InternalSephirah.g:1199:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getNotConditionAccess().getNotConditionAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,31,FOLLOW_12); 

                    				newLeafNode(otherlv_1, grammarAccess.getNotConditionAccess().getNotKeyword_0_1());
                    			
                    // InternalSephirah.g:1209:4: ( (lv_condition_2_0= ruleNotCondition ) )
                    // InternalSephirah.g:1210:5: (lv_condition_2_0= ruleNotCondition )
                    {
                    // InternalSephirah.g:1210:5: (lv_condition_2_0= ruleNotCondition )
                    // InternalSephirah.g:1211:6: lv_condition_2_0= ruleNotCondition
                    {

                    						newCompositeNode(grammarAccess.getNotConditionAccess().getConditionNotConditionParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_condition_2_0=ruleNotCondition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getNotConditionRule());
                    						}
                    						set(
                    							current,
                    							"condition",
                    							lv_condition_2_0,
                    							"com.fearlesstyrant.sephirah.Sephirah.NotCondition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSephirah.g:1230:3: this_ComparisonCondition_3= ruleComparisonCondition
                    {

                    			newCompositeNode(grammarAccess.getNotConditionAccess().getComparisonConditionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ComparisonCondition_3=ruleComparisonCondition();

                    state._fsp--;


                    			current = this_ComparisonCondition_3;
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
    // $ANTLR end "ruleNotCondition"


    // $ANTLR start "entryRuleComparisonCondition"
    // InternalSephirah.g:1242:1: entryRuleComparisonCondition returns [EObject current=null] : iv_ruleComparisonCondition= ruleComparisonCondition EOF ;
    public final EObject entryRuleComparisonCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonCondition = null;


        try {
            // InternalSephirah.g:1242:60: (iv_ruleComparisonCondition= ruleComparisonCondition EOF )
            // InternalSephirah.g:1243:2: iv_ruleComparisonCondition= ruleComparisonCondition EOF
            {
             newCompositeNode(grammarAccess.getComparisonConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComparisonCondition=ruleComparisonCondition();

            state._fsp--;

             current =iv_ruleComparisonCondition; 
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
    // $ANTLR end "entryRuleComparisonCondition"


    // $ANTLR start "ruleComparisonCondition"
    // InternalSephirah.g:1249:1: ruleComparisonCondition returns [EObject current=null] : ( () ( (lv_left_1_0= ruleAddition ) ) ( (lv_op_2_0= ruleComparisonOperator ) ) ( (lv_right_3_0= ruleAddition ) ) ) ;
    public final EObject ruleComparisonCondition() throws RecognitionException {
        EObject current = null;

        EObject lv_left_1_0 = null;

        Enumerator lv_op_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:1255:2: ( ( () ( (lv_left_1_0= ruleAddition ) ) ( (lv_op_2_0= ruleComparisonOperator ) ) ( (lv_right_3_0= ruleAddition ) ) ) )
            // InternalSephirah.g:1256:2: ( () ( (lv_left_1_0= ruleAddition ) ) ( (lv_op_2_0= ruleComparisonOperator ) ) ( (lv_right_3_0= ruleAddition ) ) )
            {
            // InternalSephirah.g:1256:2: ( () ( (lv_left_1_0= ruleAddition ) ) ( (lv_op_2_0= ruleComparisonOperator ) ) ( (lv_right_3_0= ruleAddition ) ) )
            // InternalSephirah.g:1257:3: () ( (lv_left_1_0= ruleAddition ) ) ( (lv_op_2_0= ruleComparisonOperator ) ) ( (lv_right_3_0= ruleAddition ) )
            {
            // InternalSephirah.g:1257:3: ()
            // InternalSephirah.g:1258:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getComparisonConditionAccess().getComparisonConditionAction_0(),
            					current);
            			

            }

            // InternalSephirah.g:1264:3: ( (lv_left_1_0= ruleAddition ) )
            // InternalSephirah.g:1265:4: (lv_left_1_0= ruleAddition )
            {
            // InternalSephirah.g:1265:4: (lv_left_1_0= ruleAddition )
            // InternalSephirah.g:1266:5: lv_left_1_0= ruleAddition
            {

            					newCompositeNode(grammarAccess.getComparisonConditionAccess().getLeftAdditionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_21);
            lv_left_1_0=ruleAddition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getComparisonConditionRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_1_0,
            						"com.fearlesstyrant.sephirah.Sephirah.Addition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSephirah.g:1283:3: ( (lv_op_2_0= ruleComparisonOperator ) )
            // InternalSephirah.g:1284:4: (lv_op_2_0= ruleComparisonOperator )
            {
            // InternalSephirah.g:1284:4: (lv_op_2_0= ruleComparisonOperator )
            // InternalSephirah.g:1285:5: lv_op_2_0= ruleComparisonOperator
            {

            					newCompositeNode(grammarAccess.getComparisonConditionAccess().getOpComparisonOperatorEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_11);
            lv_op_2_0=ruleComparisonOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getComparisonConditionRule());
            					}
            					set(
            						current,
            						"op",
            						lv_op_2_0,
            						"com.fearlesstyrant.sephirah.Sephirah.ComparisonOperator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSephirah.g:1302:3: ( (lv_right_3_0= ruleAddition ) )
            // InternalSephirah.g:1303:4: (lv_right_3_0= ruleAddition )
            {
            // InternalSephirah.g:1303:4: (lv_right_3_0= ruleAddition )
            // InternalSephirah.g:1304:5: lv_right_3_0= ruleAddition
            {

            					newCompositeNode(grammarAccess.getComparisonConditionAccess().getRightAdditionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_right_3_0=ruleAddition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getComparisonConditionRule());
            					}
            					set(
            						current,
            						"right",
            						lv_right_3_0,
            						"com.fearlesstyrant.sephirah.Sephirah.Addition");
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
    // $ANTLR end "ruleComparisonCondition"


    // $ANTLR start "entryRuleMethodCall"
    // InternalSephirah.g:1325:1: entryRuleMethodCall returns [EObject current=null] : iv_ruleMethodCall= ruleMethodCall EOF ;
    public final EObject entryRuleMethodCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodCall = null;


        try {
            // InternalSephirah.g:1325:51: (iv_ruleMethodCall= ruleMethodCall EOF )
            // InternalSephirah.g:1326:2: iv_ruleMethodCall= ruleMethodCall EOF
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
    // InternalSephirah.g:1332:1: ruleMethodCall returns [EObject current=null] : ( () ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) ;
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
            // InternalSephirah.g:1338:2: ( ( () ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) )
            // InternalSephirah.g:1339:2: ( () ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            {
            // InternalSephirah.g:1339:2: ( () ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            // InternalSephirah.g:1340:3: () ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')'
            {
            // InternalSephirah.g:1340:3: ()
            // InternalSephirah.g:1341:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMethodCallAccess().getMethodCallAction_0(),
            					current);
            			

            }

            // InternalSephirah.g:1347:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalSephirah.g:1348:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalSephirah.g:1348:4: (lv_name_1_0= ruleQualifiedName )
            // InternalSephirah.g:1349:5: lv_name_1_0= ruleQualifiedName
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
            		
            // InternalSephirah.g:1370:3: ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=RULE_ID && LA17_0<=RULE_INT)||LA17_0==16||LA17_0==21||(LA17_0>=32 && LA17_0<=36)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalSephirah.g:1371:4: ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    {
                    // InternalSephirah.g:1371:4: ( (lv_args_3_0= ruleExpression ) )
                    // InternalSephirah.g:1372:5: (lv_args_3_0= ruleExpression )
                    {
                    // InternalSephirah.g:1372:5: (lv_args_3_0= ruleExpression )
                    // InternalSephirah.g:1373:6: lv_args_3_0= ruleExpression
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

                    // InternalSephirah.g:1390:4: (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==17) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalSephirah.g:1391:5: otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,17,FOLLOW_11); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getMethodCallAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalSephirah.g:1395:5: ( (lv_args_5_0= ruleExpression ) )
                    	    // InternalSephirah.g:1396:6: (lv_args_5_0= ruleExpression )
                    	    {
                    	    // InternalSephirah.g:1396:6: (lv_args_5_0= ruleExpression )
                    	    // InternalSephirah.g:1397:7: lv_args_5_0= ruleExpression
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
                    	    break loop16;
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
    // InternalSephirah.g:1424:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalSephirah.g:1424:49: (iv_ruleConstant= ruleConstant EOF )
            // InternalSephirah.g:1425:2: iv_ruleConstant= ruleConstant EOF
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
    // InternalSephirah.g:1431:1: ruleConstant returns [EObject current=null] : ( () ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) ) ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_1=null;
        Token lv_value_1_2=null;
        Token lv_value_1_3=null;
        Token lv_value_1_4=null;
        Token lv_value_1_5=null;


        	enterRule();

        try {
            // InternalSephirah.g:1437:2: ( ( () ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) ) ) )
            // InternalSephirah.g:1438:2: ( () ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) ) )
            {
            // InternalSephirah.g:1438:2: ( () ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) ) )
            // InternalSephirah.g:1439:3: () ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) )
            {
            // InternalSephirah.g:1439:3: ()
            // InternalSephirah.g:1440:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getConstantAccess().getConstantAction_0(),
            					current);
            			

            }

            // InternalSephirah.g:1446:3: ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) )
            // InternalSephirah.g:1447:4: ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) )
            {
            // InternalSephirah.g:1447:4: ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) )
            // InternalSephirah.g:1448:5: (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' )
            {
            // InternalSephirah.g:1448:5: (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' )
            int alt18=5;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt18=1;
                }
                break;
            case 33:
                {
                alt18=2;
                }
                break;
            case 34:
                {
                alt18=3;
                }
                break;
            case 35:
                {
                alt18=4;
                }
                break;
            case 36:
                {
                alt18=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalSephirah.g:1449:6: lv_value_1_1= 'pi'
                    {
                    lv_value_1_1=(Token)match(input,32,FOLLOW_2); 

                    						newLeafNode(lv_value_1_1, grammarAccess.getConstantAccess().getValuePiKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstantRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalSephirah.g:1460:6: lv_value_1_2= 'G'
                    {
                    lv_value_1_2=(Token)match(input,33,FOLLOW_2); 

                    						newLeafNode(lv_value_1_2, grammarAccess.getConstantAccess().getValueGKeyword_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstantRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalSephirah.g:1471:6: lv_value_1_3= 'phi'
                    {
                    lv_value_1_3=(Token)match(input,34,FOLLOW_2); 

                    						newLeafNode(lv_value_1_3, grammarAccess.getConstantAccess().getValuePhiKeyword_1_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstantRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_3, null);
                    					

                    }
                    break;
                case 4 :
                    // InternalSephirah.g:1482:6: lv_value_1_4= 'gamma'
                    {
                    lv_value_1_4=(Token)match(input,35,FOLLOW_2); 

                    						newLeafNode(lv_value_1_4, grammarAccess.getConstantAccess().getValueGammaKeyword_1_0_3());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstantRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_4, null);
                    					

                    }
                    break;
                case 5 :
                    // InternalSephirah.g:1493:6: lv_value_1_5= 'e'
                    {
                    lv_value_1_5=(Token)match(input,36,FOLLOW_2); 

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
    // InternalSephirah.g:1510:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalSephirah.g:1510:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalSephirah.g:1511:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalSephirah.g:1517:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;



        	enterRule();

        try {
            // InternalSephirah.g:1523:2: ( (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* ) )
            // InternalSephirah.g:1524:2: (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* )
            {
            // InternalSephirah.g:1524:2: (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* )
            // InternalSephirah.g:1525:3: this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )*
            {

            			newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0());
            		
            pushFollow(FOLLOW_23);
            this_ValidID_0=ruleValidID();

            state._fsp--;


            			current.merge(this_ValidID_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalSephirah.g:1535:3: (kw= '.' this_ValidID_2= ruleValidID )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==37) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalSephirah.g:1536:4: kw= '.' this_ValidID_2= ruleValidID
            	    {
            	    kw=(Token)match(input,37,FOLLOW_5); 

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
            	    break loop19;
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
    // InternalSephirah.g:1556:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // InternalSephirah.g:1556:47: (iv_ruleValidID= ruleValidID EOF )
            // InternalSephirah.g:1557:2: iv_ruleValidID= ruleValidID EOF
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
    // InternalSephirah.g:1563:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_ESCAPED_ID_1=null;


        	enterRule();

        try {
            // InternalSephirah.g:1569:2: ( (this_ID_0= RULE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) )
            // InternalSephirah.g:1570:2: (this_ID_0= RULE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            {
            // InternalSephirah.g:1570:2: (this_ID_0= RULE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                alt20=1;
            }
            else if ( (LA20_0==RULE_ESCAPED_ID) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalSephirah.g:1571:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_0);
                    		

                    			newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSephirah.g:1579:3: this_ESCAPED_ID_1= RULE_ESCAPED_ID
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
    // InternalSephirah.g:1590:1: entryRuleDecimal returns [String current=null] : iv_ruleDecimal= ruleDecimal EOF ;
    public final String entryRuleDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimal = null;


        try {
            // InternalSephirah.g:1590:47: (iv_ruleDecimal= ruleDecimal EOF )
            // InternalSephirah.g:1591:2: iv_ruleDecimal= ruleDecimal EOF
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
    // InternalSephirah.g:1597:1: ruleDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalSephirah.g:1603:2: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) )
            // InternalSephirah.g:1604:2: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            {
            // InternalSephirah.g:1604:2: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            // InternalSephirah.g:1605:3: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )?
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_23); 

            			current.merge(this_INT_0);
            		

            			newLeafNode(this_INT_0, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_0());
            		
            // InternalSephirah.g:1612:3: (kw= '.' this_INT_2= RULE_INT )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==37) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalSephirah.g:1613:4: kw= '.' this_INT_2= RULE_INT
                    {
                    kw=(Token)match(input,37,FOLLOW_24); 

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
    // InternalSephirah.g:1630:1: ruleComparisonOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<=' ) | (enumLiteral_1= '>=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '>' ) ) ;
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
            // InternalSephirah.g:1636:2: ( ( (enumLiteral_0= '<=' ) | (enumLiteral_1= '>=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '>' ) ) )
            // InternalSephirah.g:1637:2: ( (enumLiteral_0= '<=' ) | (enumLiteral_1= '>=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '>' ) )
            {
            // InternalSephirah.g:1637:2: ( (enumLiteral_0= '<=' ) | (enumLiteral_1= '>=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '>' ) )
            int alt22=6;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt22=1;
                }
                break;
            case 39:
                {
                alt22=2;
                }
                break;
            case 40:
                {
                alt22=3;
                }
                break;
            case 41:
                {
                alt22=4;
                }
                break;
            case 42:
                {
                alt22=5;
                }
                break;
            case 43:
                {
                alt22=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalSephirah.g:1638:3: (enumLiteral_0= '<=' )
                    {
                    // InternalSephirah.g:1638:3: (enumLiteral_0= '<=' )
                    // InternalSephirah.g:1639:4: enumLiteral_0= '<='
                    {
                    enumLiteral_0=(Token)match(input,38,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorAccess().getLTEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getComparisonOperatorAccess().getLTEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSephirah.g:1646:3: (enumLiteral_1= '>=' )
                    {
                    // InternalSephirah.g:1646:3: (enumLiteral_1= '>=' )
                    // InternalSephirah.g:1647:4: enumLiteral_1= '>='
                    {
                    enumLiteral_1=(Token)match(input,39,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorAccess().getGTEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getComparisonOperatorAccess().getGTEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSephirah.g:1654:3: (enumLiteral_2= '==' )
                    {
                    // InternalSephirah.g:1654:3: (enumLiteral_2= '==' )
                    // InternalSephirah.g:1655:4: enumLiteral_2= '=='
                    {
                    enumLiteral_2=(Token)match(input,40,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorAccess().getEQEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getComparisonOperatorAccess().getEQEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSephirah.g:1662:3: (enumLiteral_3= '!=' )
                    {
                    // InternalSephirah.g:1662:3: (enumLiteral_3= '!=' )
                    // InternalSephirah.g:1663:4: enumLiteral_3= '!='
                    {
                    enumLiteral_3=(Token)match(input,41,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorAccess().getNEQEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getComparisonOperatorAccess().getNEQEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalSephirah.g:1670:3: (enumLiteral_4= '<' )
                    {
                    // InternalSephirah.g:1670:3: (enumLiteral_4= '<' )
                    // InternalSephirah.g:1671:4: enumLiteral_4= '<'
                    {
                    enumLiteral_4=(Token)match(input,42,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorAccess().getLTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getComparisonOperatorAccess().getLTEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalSephirah.g:1678:3: (enumLiteral_5= '>' )
                    {
                    // InternalSephirah.g:1678:3: (enumLiteral_5= '>' )
                    // InternalSephirah.g:1679:4: enumLiteral_5= '>'
                    {
                    enumLiteral_5=(Token)match(input,43,FOLLOW_2); 

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


    protected DFA12 dfa12 = new DFA12(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\3\uffff\2\10\4\uffff\2\10";
    static final String dfa_3s = "\1\4\2\uffff\2\16\1\uffff\1\4\2\uffff\2\16";
    static final String dfa_4s = "\1\44\2\uffff\2\53\1\uffff\1\5\2\uffff\2\53";
    static final String dfa_5s = "\1\uffff\1\1\1\2\2\uffff\1\4\1\uffff\1\3\1\5\2\uffff";
    static final String dfa_6s = "\13\uffff}>";
    static final String[] dfa_7s = {
            "\1\3\1\4\1\2\11\uffff\1\1\17\uffff\5\5",
            "",
            "",
            "\1\10\1\uffff\1\7\2\10\3\uffff\11\10\6\uffff\1\6\6\10",
            "\1\10\1\uffff\1\7\2\10\3\uffff\11\10\6\uffff\1\6\6\10",
            "",
            "\1\11\1\12",
            "",
            "",
            "\1\10\1\uffff\1\7\2\10\3\uffff\11\10\6\uffff\1\6\6\10",
            "\1\10\1\uffff\1\7\2\10\3\uffff\11\10\6\uffff\1\6\6\10"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "960:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= ruleDecimal ) ) ) | this_MethodCall_5= ruleMethodCall | this_Constant_6= ruleConstant | this_Variable_7= ruleVariable )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000001F0031A072L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000001F00318072L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000040030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000001F00318070L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000001F80318070L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000000000C000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00000FC000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000001F00358070L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000040L});

}