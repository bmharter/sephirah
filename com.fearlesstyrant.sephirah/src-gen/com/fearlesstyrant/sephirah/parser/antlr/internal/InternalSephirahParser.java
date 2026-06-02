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
    // InternalSephirah.g:71:1: ruleFormulaModel returns [EObject current=null] : ( ( (lv_name_0_0= ruleDocName ) )? ( (lv_imports_1_0= ruleImport ) )* ( (lv_methodDefs_2_0= ruleDefinition ) )* ( (lv_variables_3_0= ruleVariableAssignment ) )* ( (lv_values_4_0= ruleEvaluation ) )* ) ;
    public final EObject ruleFormulaModel() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;

        EObject lv_imports_1_0 = null;

        EObject lv_methodDefs_2_0 = null;

        EObject lv_variables_3_0 = null;

        EObject lv_values_4_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:77:2: ( ( ( (lv_name_0_0= ruleDocName ) )? ( (lv_imports_1_0= ruleImport ) )* ( (lv_methodDefs_2_0= ruleDefinition ) )* ( (lv_variables_3_0= ruleVariableAssignment ) )* ( (lv_values_4_0= ruleEvaluation ) )* ) )
            // InternalSephirah.g:78:2: ( ( (lv_name_0_0= ruleDocName ) )? ( (lv_imports_1_0= ruleImport ) )* ( (lv_methodDefs_2_0= ruleDefinition ) )* ( (lv_variables_3_0= ruleVariableAssignment ) )* ( (lv_values_4_0= ruleEvaluation ) )* )
            {
            // InternalSephirah.g:78:2: ( ( (lv_name_0_0= ruleDocName ) )? ( (lv_imports_1_0= ruleImport ) )* ( (lv_methodDefs_2_0= ruleDefinition ) )* ( (lv_variables_3_0= ruleVariableAssignment ) )* ( (lv_values_4_0= ruleEvaluation ) )* )
            // InternalSephirah.g:79:3: ( (lv_name_0_0= ruleDocName ) )? ( (lv_imports_1_0= ruleImport ) )* ( (lv_methodDefs_2_0= ruleDefinition ) )* ( (lv_variables_3_0= ruleVariableAssignment ) )* ( (lv_values_4_0= ruleEvaluation ) )*
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

            // InternalSephirah.g:117:3: ( (lv_methodDefs_2_0= ruleDefinition ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalSephirah.g:118:4: (lv_methodDefs_2_0= ruleDefinition )
            	    {
            	    // InternalSephirah.g:118:4: (lv_methodDefs_2_0= ruleDefinition )
            	    // InternalSephirah.g:119:5: lv_methodDefs_2_0= ruleDefinition
            	    {

            	    					newCompositeNode(grammarAccess.getFormulaModelAccess().getMethodDefsDefinitionParserRuleCall_2_0());
            	    				
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
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalSephirah.g:136:3: ( (lv_variables_3_0= ruleVariableAssignment ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==20) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalSephirah.g:137:4: (lv_variables_3_0= ruleVariableAssignment )
            	    {
            	    // InternalSephirah.g:137:4: (lv_variables_3_0= ruleVariableAssignment )
            	    // InternalSephirah.g:138:5: lv_variables_3_0= ruleVariableAssignment
            	    {

            	    					newCompositeNode(grammarAccess.getFormulaModelAccess().getVariablesVariableAssignmentParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_5);
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
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalSephirah.g:155:3: ( (lv_values_4_0= ruleEvaluation ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=RULE_ID && LA5_0<=RULE_INT)||LA5_0==16||(LA5_0>=26 && LA5_0<=30)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalSephirah.g:156:4: (lv_values_4_0= ruleEvaluation )
            	    {
            	    // InternalSephirah.g:156:4: (lv_values_4_0= ruleEvaluation )
            	    // InternalSephirah.g:157:5: lv_values_4_0= ruleEvaluation
            	    {

            	    					newCompositeNode(grammarAccess.getFormulaModelAccess().getValuesEvaluationParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_6);
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
            	    break;

            	default :
            	    break loop5;
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
    // InternalSephirah.g:178:1: entryRuleDocName returns [EObject current=null] : iv_ruleDocName= ruleDocName EOF ;
    public final EObject entryRuleDocName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocName = null;


        try {
            // InternalSephirah.g:178:48: (iv_ruleDocName= ruleDocName EOF )
            // InternalSephirah.g:179:2: iv_ruleDocName= ruleDocName EOF
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
    // InternalSephirah.g:185:1: ruleDocName returns [EObject current=null] : (otherlv_0= 'SephirahDoc' ( (lv_name_1_0= ruleQualifiedName ) ) ) ;
    public final EObject ruleDocName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:191:2: ( (otherlv_0= 'SephirahDoc' ( (lv_name_1_0= ruleQualifiedName ) ) ) )
            // InternalSephirah.g:192:2: (otherlv_0= 'SephirahDoc' ( (lv_name_1_0= ruleQualifiedName ) ) )
            {
            // InternalSephirah.g:192:2: (otherlv_0= 'SephirahDoc' ( (lv_name_1_0= ruleQualifiedName ) ) )
            // InternalSephirah.g:193:3: otherlv_0= 'SephirahDoc' ( (lv_name_1_0= ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,12,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getDocNameAccess().getSephirahDocKeyword_0());
            		
            // InternalSephirah.g:197:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalSephirah.g:198:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalSephirah.g:198:4: (lv_name_1_0= ruleQualifiedName )
            // InternalSephirah.g:199:5: lv_name_1_0= ruleQualifiedName
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
    // InternalSephirah.g:220:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalSephirah.g:220:47: (iv_ruleImport= ruleImport EOF )
            // InternalSephirah.g:221:2: iv_ruleImport= ruleImport EOF
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
    // InternalSephirah.g:227:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= ';' ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:233:2: ( (otherlv_0= 'import' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= ';' ) )
            // InternalSephirah.g:234:2: (otherlv_0= 'import' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= ';' )
            {
            // InternalSephirah.g:234:2: (otherlv_0= 'import' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= ';' )
            // InternalSephirah.g:235:3: otherlv_0= 'import' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalSephirah.g:239:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalSephirah.g:240:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalSephirah.g:240:4: (lv_name_1_0= ruleQualifiedName )
            // InternalSephirah.g:241:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getImportAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_8);
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
    // InternalSephirah.g:266:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // InternalSephirah.g:266:51: (iv_ruleDefinition= ruleDefinition EOF )
            // InternalSephirah.g:267:2: iv_ruleDefinition= ruleDefinition EOF
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
    // InternalSephirah.g:273:1: ruleDefinition returns [EObject current=null] : (otherlv_0= 'def' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )* )? otherlv_6= ')' otherlv_7= '=' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';' ) ;
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
            // InternalSephirah.g:279:2: ( (otherlv_0= 'def' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )* )? otherlv_6= ')' otherlv_7= '=' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
            // InternalSephirah.g:280:2: (otherlv_0= 'def' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )* )? otherlv_6= ')' otherlv_7= '=' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';' )
            {
            // InternalSephirah.g:280:2: (otherlv_0= 'def' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )* )? otherlv_6= ')' otherlv_7= '=' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';' )
            // InternalSephirah.g:281:3: otherlv_0= 'def' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )* )? otherlv_6= ')' otherlv_7= '=' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getDefinitionAccess().getDefKeyword_0());
            		
            // InternalSephirah.g:285:3: ( (lv_name_1_0= ruleValidID ) )
            // InternalSephirah.g:286:4: (lv_name_1_0= ruleValidID )
            {
            // InternalSephirah.g:286:4: (lv_name_1_0= ruleValidID )
            // InternalSephirah.g:287:5: lv_name_1_0= ruleValidID
            {

            					newCompositeNode(grammarAccess.getDefinitionAccess().getNameValidIDParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_9);
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

            otherlv_2=(Token)match(input,16,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_2());
            		
            // InternalSephirah.g:308:3: ( ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_ID && LA7_0<=RULE_ESCAPED_ID)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalSephirah.g:309:4: ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )*
                    {
                    // InternalSephirah.g:309:4: ( (lv_args_3_0= ruleDefinitionVariable ) )
                    // InternalSephirah.g:310:5: (lv_args_3_0= ruleDefinitionVariable )
                    {
                    // InternalSephirah.g:310:5: (lv_args_3_0= ruleDefinitionVariable )
                    // InternalSephirah.g:311:6: lv_args_3_0= ruleDefinitionVariable
                    {

                    						newCompositeNode(grammarAccess.getDefinitionAccess().getArgsDefinitionVariableParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_11);
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

                    // InternalSephirah.g:328:4: (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==17) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalSephirah.g:329:5: otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) )
                    	    {
                    	    otherlv_4=(Token)match(input,17,FOLLOW_7); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getDefinitionAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalSephirah.g:333:5: ( (lv_args_5_0= ruleDefinitionVariable ) )
                    	    // InternalSephirah.g:334:6: (lv_args_5_0= ruleDefinitionVariable )
                    	    {
                    	    // InternalSephirah.g:334:6: (lv_args_5_0= ruleDefinitionVariable )
                    	    // InternalSephirah.g:335:7: lv_args_5_0= ruleDefinitionVariable
                    	    {

                    	    							newCompositeNode(grammarAccess.getDefinitionAccess().getArgsDefinitionVariableParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
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
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,18,FOLLOW_12); 

            			newLeafNode(otherlv_6, grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_4());
            		
            otherlv_7=(Token)match(input,19,FOLLOW_13); 

            			newLeafNode(otherlv_7, grammarAccess.getDefinitionAccess().getEqualsSignKeyword_5());
            		
            // InternalSephirah.g:362:3: ( (lv_expr_8_0= ruleExpression ) )
            // InternalSephirah.g:363:4: (lv_expr_8_0= ruleExpression )
            {
            // InternalSephirah.g:363:4: (lv_expr_8_0= ruleExpression )
            // InternalSephirah.g:364:5: lv_expr_8_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getDefinitionAccess().getExprExpressionParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_8);
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
    // InternalSephirah.g:389:1: entryRuleVariableAssignment returns [EObject current=null] : iv_ruleVariableAssignment= ruleVariableAssignment EOF ;
    public final EObject entryRuleVariableAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableAssignment = null;


        try {
            // InternalSephirah.g:389:59: (iv_ruleVariableAssignment= ruleVariableAssignment EOF )
            // InternalSephirah.g:390:2: iv_ruleVariableAssignment= ruleVariableAssignment EOF
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
    // InternalSephirah.g:396:1: ruleVariableAssignment returns [EObject current=null] : ( () otherlv_1= 'var' ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' ) ;
    public final EObject ruleVariableAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:402:2: ( ( () otherlv_1= 'var' ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' ) )
            // InternalSephirah.g:403:2: ( () otherlv_1= 'var' ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' )
            {
            // InternalSephirah.g:403:2: ( () otherlv_1= 'var' ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' )
            // InternalSephirah.g:404:3: () otherlv_1= 'var' ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';'
            {
            // InternalSephirah.g:404:3: ()
            // InternalSephirah.g:405:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVariableAssignmentAccess().getVariableAssignmentAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,20,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getVariableAssignmentAccess().getVarKeyword_1());
            		
            // InternalSephirah.g:415:3: ( (lv_name_2_0= ruleValidID ) )
            // InternalSephirah.g:416:4: (lv_name_2_0= ruleValidID )
            {
            // InternalSephirah.g:416:4: (lv_name_2_0= ruleValidID )
            // InternalSephirah.g:417:5: lv_name_2_0= ruleValidID
            {

            					newCompositeNode(grammarAccess.getVariableAssignmentAccess().getNameValidIDParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_12);
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

            otherlv_3=(Token)match(input,19,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getVariableAssignmentAccess().getEqualsSignKeyword_3());
            		
            // InternalSephirah.g:438:3: ( (lv_value_4_0= ruleExpression ) )
            // InternalSephirah.g:439:4: (lv_value_4_0= ruleExpression )
            {
            // InternalSephirah.g:439:4: (lv_value_4_0= ruleExpression )
            // InternalSephirah.g:440:5: lv_value_4_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getVariableAssignmentAccess().getValueExpressionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_8);
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
    // InternalSephirah.g:465:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalSephirah.g:465:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalSephirah.g:466:2: iv_ruleVariable= ruleVariable EOF
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
    // InternalSephirah.g:472:1: ruleVariable returns [EObject current=null] : ( () ( (lv_name_1_0= ruleQualifiedName ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:478:2: ( ( () ( (lv_name_1_0= ruleQualifiedName ) ) ) )
            // InternalSephirah.g:479:2: ( () ( (lv_name_1_0= ruleQualifiedName ) ) )
            {
            // InternalSephirah.g:479:2: ( () ( (lv_name_1_0= ruleQualifiedName ) ) )
            // InternalSephirah.g:480:3: () ( (lv_name_1_0= ruleQualifiedName ) )
            {
            // InternalSephirah.g:480:3: ()
            // InternalSephirah.g:481:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVariableAccess().getVariableAction_0(),
            					current);
            			

            }

            // InternalSephirah.g:487:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalSephirah.g:488:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalSephirah.g:488:4: (lv_name_1_0= ruleQualifiedName )
            // InternalSephirah.g:489:5: lv_name_1_0= ruleQualifiedName
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
    // InternalSephirah.g:510:1: entryRuleDefinitionVariable returns [EObject current=null] : iv_ruleDefinitionVariable= ruleDefinitionVariable EOF ;
    public final EObject entryRuleDefinitionVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinitionVariable = null;


        try {
            // InternalSephirah.g:510:59: (iv_ruleDefinitionVariable= ruleDefinitionVariable EOF )
            // InternalSephirah.g:511:2: iv_ruleDefinitionVariable= ruleDefinitionVariable EOF
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
    // InternalSephirah.g:517:1: ruleDefinitionVariable returns [EObject current=null] : ( () ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleDefinitionVariable() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:523:2: ( ( () ( (lv_name_1_0= ruleValidID ) ) ) )
            // InternalSephirah.g:524:2: ( () ( (lv_name_1_0= ruleValidID ) ) )
            {
            // InternalSephirah.g:524:2: ( () ( (lv_name_1_0= ruleValidID ) ) )
            // InternalSephirah.g:525:3: () ( (lv_name_1_0= ruleValidID ) )
            {
            // InternalSephirah.g:525:3: ()
            // InternalSephirah.g:526:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDefinitionVariableAccess().getDefinitionVariableAction_0(),
            					current);
            			

            }

            // InternalSephirah.g:532:3: ( (lv_name_1_0= ruleValidID ) )
            // InternalSephirah.g:533:4: (lv_name_1_0= ruleValidID )
            {
            // InternalSephirah.g:533:4: (lv_name_1_0= ruleValidID )
            // InternalSephirah.g:534:5: lv_name_1_0= ruleValidID
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
    // InternalSephirah.g:555:1: entryRuleEvaluation returns [EObject current=null] : iv_ruleEvaluation= ruleEvaluation EOF ;
    public final EObject entryRuleEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvaluation = null;


        try {
            // InternalSephirah.g:555:51: (iv_ruleEvaluation= ruleEvaluation EOF )
            // InternalSephirah.g:556:2: iv_ruleEvaluation= ruleEvaluation EOF
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
    // InternalSephirah.g:562:1: ruleEvaluation returns [EObject current=null] : ( ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';' ) ;
    public final EObject ruleEvaluation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_0_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:568:2: ( ( ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';' ) )
            // InternalSephirah.g:569:2: ( ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';' )
            {
            // InternalSephirah.g:569:2: ( ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';' )
            // InternalSephirah.g:570:3: ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';'
            {
            // InternalSephirah.g:570:3: ( (lv_expression_0_0= ruleExpression ) )
            // InternalSephirah.g:571:4: (lv_expression_0_0= ruleExpression )
            {
            // InternalSephirah.g:571:4: (lv_expression_0_0= ruleExpression )
            // InternalSephirah.g:572:5: lv_expression_0_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getEvaluationAccess().getExpressionExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_8);
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
    // InternalSephirah.g:597:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalSephirah.g:597:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalSephirah.g:598:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalSephirah.g:604:1: ruleExpression returns [EObject current=null] : this_Addition_0= ruleAddition ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Addition_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:610:2: (this_Addition_0= ruleAddition )
            // InternalSephirah.g:611:2: this_Addition_0= ruleAddition
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
    // InternalSephirah.g:622:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // InternalSephirah.g:622:49: (iv_ruleAddition= ruleAddition EOF )
            // InternalSephirah.g:623:2: iv_ruleAddition= ruleAddition EOF
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
    // InternalSephirah.g:629:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:635:2: ( (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) )
            // InternalSephirah.g:636:2: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            {
            // InternalSephirah.g:636:2: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            // InternalSephirah.g:637:3: this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            {

            			newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0());
            		
            pushFollow(FOLLOW_14);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;


            			current = this_Multiplication_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSephirah.g:645:3: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=21 && LA9_0<=22)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalSephirah.g:646:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) )
            	    {
            	    // InternalSephirah.g:646:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt8=2;
            	    int LA8_0 = input.LA(1);

            	    if ( (LA8_0==21) ) {
            	        alt8=1;
            	    }
            	    else if ( (LA8_0==22) ) {
            	        alt8=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 8, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt8) {
            	        case 1 :
            	            // InternalSephirah.g:647:5: ( () otherlv_2= '+' )
            	            {
            	            // InternalSephirah.g:647:5: ( () otherlv_2= '+' )
            	            // InternalSephirah.g:648:6: () otherlv_2= '+'
            	            {
            	            // InternalSephirah.g:648:6: ()
            	            // InternalSephirah.g:649:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getAdditionAccess().getAddLeftAction_1_0_0_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_2=(Token)match(input,21,FOLLOW_13); 

            	            						newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalSephirah.g:661:5: ( () otherlv_4= '-' )
            	            {
            	            // InternalSephirah.g:661:5: ( () otherlv_4= '-' )
            	            // InternalSephirah.g:662:6: () otherlv_4= '-'
            	            {
            	            // InternalSephirah.g:662:6: ()
            	            // InternalSephirah.g:663:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getAdditionAccess().getSubtractLeftAction_1_0_1_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_4=(Token)match(input,22,FOLLOW_13); 

            	            						newLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalSephirah.g:675:4: ( (lv_right_5_0= ruleMultiplication ) )
            	    // InternalSephirah.g:676:5: (lv_right_5_0= ruleMultiplication )
            	    {
            	    // InternalSephirah.g:676:5: (lv_right_5_0= ruleMultiplication )
            	    // InternalSephirah.g:677:6: lv_right_5_0= ruleMultiplication
            	    {

            	    						newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_14);
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
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleMultiplication"
    // InternalSephirah.g:699:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // InternalSephirah.g:699:55: (iv_ruleMultiplication= ruleMultiplication EOF )
            // InternalSephirah.g:700:2: iv_ruleMultiplication= ruleMultiplication EOF
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
    // InternalSephirah.g:706:1: ruleMultiplication returns [EObject current=null] : (this_Exponent_0= ruleExponent ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleExponent ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Exponent_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:712:2: ( (this_Exponent_0= ruleExponent ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleExponent ) ) )* ) )
            // InternalSephirah.g:713:2: (this_Exponent_0= ruleExponent ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleExponent ) ) )* )
            {
            // InternalSephirah.g:713:2: (this_Exponent_0= ruleExponent ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleExponent ) ) )* )
            // InternalSephirah.g:714:3: this_Exponent_0= ruleExponent ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleExponent ) ) )*
            {

            			newCompositeNode(grammarAccess.getMultiplicationAccess().getExponentParserRuleCall_0());
            		
            pushFollow(FOLLOW_15);
            this_Exponent_0=ruleExponent();

            state._fsp--;


            			current = this_Exponent_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSephirah.g:722:3: ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleExponent ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=23 && LA11_0<=24)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalSephirah.g:723:4: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleExponent ) )
            	    {
            	    // InternalSephirah.g:723:4: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) )
            	    int alt10=2;
            	    int LA10_0 = input.LA(1);

            	    if ( (LA10_0==23) ) {
            	        alt10=1;
            	    }
            	    else if ( (LA10_0==24) ) {
            	        alt10=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 10, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt10) {
            	        case 1 :
            	            // InternalSephirah.g:724:5: ( () otherlv_2= '*' )
            	            {
            	            // InternalSephirah.g:724:5: ( () otherlv_2= '*' )
            	            // InternalSephirah.g:725:6: () otherlv_2= '*'
            	            {
            	            // InternalSephirah.g:725:6: ()
            	            // InternalSephirah.g:726:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getMultiplicationAccess().getMultiplyLeftAction_1_0_0_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_2=(Token)match(input,23,FOLLOW_13); 

            	            						newLeafNode(otherlv_2, grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalSephirah.g:738:5: ( () otherlv_4= '/' )
            	            {
            	            // InternalSephirah.g:738:5: ( () otherlv_4= '/' )
            	            // InternalSephirah.g:739:6: () otherlv_4= '/'
            	            {
            	            // InternalSephirah.g:739:6: ()
            	            // InternalSephirah.g:740:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getMultiplicationAccess().getDivideLeftAction_1_0_1_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_4=(Token)match(input,24,FOLLOW_13); 

            	            						newLeafNode(otherlv_4, grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_0_1_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalSephirah.g:752:4: ( (lv_right_5_0= ruleExponent ) )
            	    // InternalSephirah.g:753:5: (lv_right_5_0= ruleExponent )
            	    {
            	    // InternalSephirah.g:753:5: (lv_right_5_0= ruleExponent )
            	    // InternalSephirah.g:754:6: lv_right_5_0= ruleExponent
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplicationAccess().getRightExponentParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_15);
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
            	    break loop11;
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
    // InternalSephirah.g:776:1: entryRuleExponent returns [EObject current=null] : iv_ruleExponent= ruleExponent EOF ;
    public final EObject entryRuleExponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExponent = null;


        try {
            // InternalSephirah.g:776:49: (iv_ruleExponent= ruleExponent EOF )
            // InternalSephirah.g:777:2: iv_ruleExponent= ruleExponent EOF
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
    // InternalSephirah.g:783:1: ruleExponent returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '^' ( (lv_right_3_0= ruleExponent ) ) )? ) ;
    public final EObject ruleExponent() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_PrimaryExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:789:2: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '^' ( (lv_right_3_0= ruleExponent ) ) )? ) )
            // InternalSephirah.g:790:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '^' ( (lv_right_3_0= ruleExponent ) ) )? )
            {
            // InternalSephirah.g:790:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '^' ( (lv_right_3_0= ruleExponent ) ) )? )
            // InternalSephirah.g:791:3: this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '^' ( (lv_right_3_0= ruleExponent ) ) )?
            {

            			newCompositeNode(grammarAccess.getExponentAccess().getPrimaryExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_16);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;


            			current = this_PrimaryExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSephirah.g:799:3: ( () otherlv_2= '^' ( (lv_right_3_0= ruleExponent ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==25) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalSephirah.g:800:4: () otherlv_2= '^' ( (lv_right_3_0= ruleExponent ) )
                    {
                    // InternalSephirah.g:800:4: ()
                    // InternalSephirah.g:801:5: 
                    {

                    					current = forceCreateModelElementAndSet(
                    						grammarAccess.getExponentAccess().getExponentLeftAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_2=(Token)match(input,25,FOLLOW_13); 

                    				newLeafNode(otherlv_2, grammarAccess.getExponentAccess().getCircumflexAccentKeyword_1_1());
                    			
                    // InternalSephirah.g:811:4: ( (lv_right_3_0= ruleExponent ) )
                    // InternalSephirah.g:812:5: (lv_right_3_0= ruleExponent )
                    {
                    // InternalSephirah.g:812:5: (lv_right_3_0= ruleExponent )
                    // InternalSephirah.g:813:6: lv_right_3_0= ruleExponent
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
    // InternalSephirah.g:835:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalSephirah.g:835:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalSephirah.g:836:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalSephirah.g:842:1: rulePrimaryExpression returns [EObject current=null] : ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= ruleDecimal ) ) ) | this_MethodCall_5= ruleMethodCall | this_Constant_6= ruleConstant | this_Variable_7= ruleVariable ) ;
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
            // InternalSephirah.g:848:2: ( ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= ruleDecimal ) ) ) | this_MethodCall_5= ruleMethodCall | this_Constant_6= ruleConstant | this_Variable_7= ruleVariable ) )
            // InternalSephirah.g:849:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= ruleDecimal ) ) ) | this_MethodCall_5= ruleMethodCall | this_Constant_6= ruleConstant | this_Variable_7= ruleVariable )
            {
            // InternalSephirah.g:849:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= ruleDecimal ) ) ) | this_MethodCall_5= ruleMethodCall | this_Constant_6= ruleConstant | this_Variable_7= ruleVariable )
            int alt13=5;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // InternalSephirah.g:850:3: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    {
                    // InternalSephirah.g:850:3: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    // InternalSephirah.g:851:4: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,16,FOLLOW_13); 

                    				newLeafNode(otherlv_0, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_0());
                    			

                    				newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_17);
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
                    // InternalSephirah.g:869:3: ( () ( (lv_value_4_0= ruleDecimal ) ) )
                    {
                    // InternalSephirah.g:869:3: ( () ( (lv_value_4_0= ruleDecimal ) ) )
                    // InternalSephirah.g:870:4: () ( (lv_value_4_0= ruleDecimal ) )
                    {
                    // InternalSephirah.g:870:4: ()
                    // InternalSephirah.g:871:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimaryExpressionAccess().getNumberLiteralAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSephirah.g:877:4: ( (lv_value_4_0= ruleDecimal ) )
                    // InternalSephirah.g:878:5: (lv_value_4_0= ruleDecimal )
                    {
                    // InternalSephirah.g:878:5: (lv_value_4_0= ruleDecimal )
                    // InternalSephirah.g:879:6: lv_value_4_0= ruleDecimal
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
                    // InternalSephirah.g:898:3: this_MethodCall_5= ruleMethodCall
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
                    // InternalSephirah.g:907:3: this_Constant_6= ruleConstant
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
                    // InternalSephirah.g:916:3: this_Variable_7= ruleVariable
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
    // InternalSephirah.g:928:1: entryRuleMethodCall returns [EObject current=null] : iv_ruleMethodCall= ruleMethodCall EOF ;
    public final EObject entryRuleMethodCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodCall = null;


        try {
            // InternalSephirah.g:928:51: (iv_ruleMethodCall= ruleMethodCall EOF )
            // InternalSephirah.g:929:2: iv_ruleMethodCall= ruleMethodCall EOF
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
    // InternalSephirah.g:935:1: ruleMethodCall returns [EObject current=null] : ( () ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) ;
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
            // InternalSephirah.g:941:2: ( ( () ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) )
            // InternalSephirah.g:942:2: ( () ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            {
            // InternalSephirah.g:942:2: ( () ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            // InternalSephirah.g:943:3: () ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')'
            {
            // InternalSephirah.g:943:3: ()
            // InternalSephirah.g:944:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMethodCallAccess().getMethodCallAction_0(),
            					current);
            			

            }

            // InternalSephirah.g:950:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalSephirah.g:951:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalSephirah.g:951:4: (lv_name_1_0= ruleQualifiedName )
            // InternalSephirah.g:952:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getMethodCallAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_9);
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

            otherlv_2=(Token)match(input,16,FOLLOW_18); 

            			newLeafNode(otherlv_2, grammarAccess.getMethodCallAccess().getLeftParenthesisKeyword_2());
            		
            // InternalSephirah.g:973:3: ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=RULE_ID && LA15_0<=RULE_INT)||LA15_0==16||(LA15_0>=26 && LA15_0<=30)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalSephirah.g:974:4: ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    {
                    // InternalSephirah.g:974:4: ( (lv_args_3_0= ruleExpression ) )
                    // InternalSephirah.g:975:5: (lv_args_3_0= ruleExpression )
                    {
                    // InternalSephirah.g:975:5: (lv_args_3_0= ruleExpression )
                    // InternalSephirah.g:976:6: lv_args_3_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getMethodCallAccess().getArgsExpressionParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_11);
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

                    // InternalSephirah.g:993:4: (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==17) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalSephirah.g:994:5: otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,17,FOLLOW_13); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getMethodCallAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalSephirah.g:998:5: ( (lv_args_5_0= ruleExpression ) )
                    	    // InternalSephirah.g:999:6: (lv_args_5_0= ruleExpression )
                    	    {
                    	    // InternalSephirah.g:999:6: (lv_args_5_0= ruleExpression )
                    	    // InternalSephirah.g:1000:7: lv_args_5_0= ruleExpression
                    	    {

                    	    							newCompositeNode(grammarAccess.getMethodCallAccess().getArgsExpressionParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
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
                    	    break loop14;
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
    // InternalSephirah.g:1027:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalSephirah.g:1027:49: (iv_ruleConstant= ruleConstant EOF )
            // InternalSephirah.g:1028:2: iv_ruleConstant= ruleConstant EOF
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
    // InternalSephirah.g:1034:1: ruleConstant returns [EObject current=null] : ( () ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) ) ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_1=null;
        Token lv_value_1_2=null;
        Token lv_value_1_3=null;
        Token lv_value_1_4=null;
        Token lv_value_1_5=null;


        	enterRule();

        try {
            // InternalSephirah.g:1040:2: ( ( () ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) ) ) )
            // InternalSephirah.g:1041:2: ( () ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) ) )
            {
            // InternalSephirah.g:1041:2: ( () ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) ) )
            // InternalSephirah.g:1042:3: () ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) )
            {
            // InternalSephirah.g:1042:3: ()
            // InternalSephirah.g:1043:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getConstantAccess().getConstantAction_0(),
            					current);
            			

            }

            // InternalSephirah.g:1049:3: ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) )
            // InternalSephirah.g:1050:4: ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) )
            {
            // InternalSephirah.g:1050:4: ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) )
            // InternalSephirah.g:1051:5: (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' )
            {
            // InternalSephirah.g:1051:5: (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' )
            int alt16=5;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt16=1;
                }
                break;
            case 27:
                {
                alt16=2;
                }
                break;
            case 28:
                {
                alt16=3;
                }
                break;
            case 29:
                {
                alt16=4;
                }
                break;
            case 30:
                {
                alt16=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalSephirah.g:1052:6: lv_value_1_1= 'pi'
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
                    // InternalSephirah.g:1063:6: lv_value_1_2= 'G'
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
                    // InternalSephirah.g:1074:6: lv_value_1_3= 'phi'
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
                    // InternalSephirah.g:1085:6: lv_value_1_4= 'gamma'
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
                    // InternalSephirah.g:1096:6: lv_value_1_5= 'e'
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
    // InternalSephirah.g:1113:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalSephirah.g:1113:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalSephirah.g:1114:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalSephirah.g:1120:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;



        	enterRule();

        try {
            // InternalSephirah.g:1126:2: ( (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* ) )
            // InternalSephirah.g:1127:2: (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* )
            {
            // InternalSephirah.g:1127:2: (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* )
            // InternalSephirah.g:1128:3: this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )*
            {

            			newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0());
            		
            pushFollow(FOLLOW_19);
            this_ValidID_0=ruleValidID();

            state._fsp--;


            			current.merge(this_ValidID_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalSephirah.g:1138:3: (kw= '.' this_ValidID_2= ruleValidID )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==31) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalSephirah.g:1139:4: kw= '.' this_ValidID_2= ruleValidID
            	    {
            	    kw=(Token)match(input,31,FOLLOW_7); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			

            	    				newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1());
            	    			
            	    pushFollow(FOLLOW_19);
            	    this_ValidID_2=ruleValidID();

            	    state._fsp--;


            	    				current.merge(this_ValidID_2);
            	    			

            	    				afterParserOrEnumRuleCall();
            	    			

            	    }
            	    break;

            	default :
            	    break loop17;
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
    // InternalSephirah.g:1159:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // InternalSephirah.g:1159:47: (iv_ruleValidID= ruleValidID EOF )
            // InternalSephirah.g:1160:2: iv_ruleValidID= ruleValidID EOF
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
    // InternalSephirah.g:1166:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_ESCAPED_ID_1=null;


        	enterRule();

        try {
            // InternalSephirah.g:1172:2: ( (this_ID_0= RULE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) )
            // InternalSephirah.g:1173:2: (this_ID_0= RULE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            {
            // InternalSephirah.g:1173:2: (this_ID_0= RULE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                alt18=1;
            }
            else if ( (LA18_0==RULE_ESCAPED_ID) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalSephirah.g:1174:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_0);
                    		

                    			newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSephirah.g:1182:3: this_ESCAPED_ID_1= RULE_ESCAPED_ID
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
    // InternalSephirah.g:1193:1: entryRuleDecimal returns [String current=null] : iv_ruleDecimal= ruleDecimal EOF ;
    public final String entryRuleDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimal = null;


        try {
            // InternalSephirah.g:1193:47: (iv_ruleDecimal= ruleDecimal EOF )
            // InternalSephirah.g:1194:2: iv_ruleDecimal= ruleDecimal EOF
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
    // InternalSephirah.g:1200:1: ruleDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalSephirah.g:1206:2: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) )
            // InternalSephirah.g:1207:2: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            {
            // InternalSephirah.g:1207:2: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            // InternalSephirah.g:1208:3: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )?
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_19); 

            			current.merge(this_INT_0);
            		

            			newLeafNode(this_INT_0, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_0());
            		
            // InternalSephirah.g:1215:3: (kw= '.' this_INT_2= RULE_INT )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==31) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalSephirah.g:1216:4: kw= '.' this_INT_2= RULE_INT
                    {
                    kw=(Token)match(input,31,FOLLOW_20); 

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


    protected DFA13 dfa13 = new DFA13(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\3\uffff\2\7\4\uffff\2\7";
    static final String dfa_3s = "\1\4\2\uffff\2\16\1\uffff\1\4\2\uffff\2\16";
    static final String dfa_4s = "\1\36\2\uffff\2\37\1\uffff\1\5\2\uffff\2\37";
    static final String dfa_5s = "\1\uffff\1\1\1\2\2\uffff\1\4\1\uffff\1\5\1\3\2\uffff";
    static final String dfa_6s = "\13\uffff}>";
    static final String[] dfa_7s = {
            "\1\3\1\4\1\2\11\uffff\1\1\11\uffff\5\5",
            "",
            "",
            "\1\7\1\uffff\1\10\2\7\2\uffff\5\7\5\uffff\1\6",
            "\1\7\1\uffff\1\10\2\7\2\uffff\5\7\5\uffff\1\6",
            "",
            "\1\11\1\12",
            "",
            "",
            "\1\7\1\uffff\1\10\2\7\2\uffff\5\7\5\uffff\1\6",
            "\1\7\1\uffff\1\10\2\7\2\uffff\5\7\5\uffff\1\6"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "849:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= ruleDecimal ) ) ) | this_MethodCall_5= ruleMethodCall | this_Constant_6= ruleConstant | this_Variable_7= ruleVariable )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000007C11A072L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000000007C118072L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000007C110072L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000007C010072L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040030L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x000000007C010070L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001800002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x000000007C050070L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000040L});

}