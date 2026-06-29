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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_ESCAPED_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'SephirahDoc'", "'NumDoc'", "'import'", "'as'", "';'", "'def'", "'('", "','", "')'", "'='", "'var'", "'if'", "'then'", "'else'", "'or'", "'and'", "'not'", "'['", "']'", "'+'", "'-'", "'*'", "'/'", "'^'", "'true'", "'false'", "'pi'", "'G'", "'phi'", "'gamma'", "'e'", "'.'", "'<='", "'>='", "'=='", "'!='", "'<'", "'>'"
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
    public static final int T__48=48;
    public static final int T__49=49;
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

            if ( ((LA1_0>=12 && LA1_0<=13)) ) {
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

                if ( (LA2_0==14) ) {
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
                case 17:
                    {
                    alt3=1;
                    }
                    break;
                case 22:
                    {
                    alt3=2;
                    }
                    break;
                case RULE_ID:
                case RULE_ESCAPED_ID:
                case RULE_INT:
                case 18:
                case 23:
                case 28:
                case 29:
                case 32:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
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
    // InternalSephirah.g:190:1: ruleDocName returns [EObject current=null] : ( (otherlv_0= 'SephirahDoc' ( (lv_name_1_0= ruleQualifiedName ) ) ) | (otherlv_2= 'NumDoc' ( (lv_name_3_0= ruleQualifiedName ) ) ) ) ;
    public final EObject ruleDocName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:196:2: ( ( (otherlv_0= 'SephirahDoc' ( (lv_name_1_0= ruleQualifiedName ) ) ) | (otherlv_2= 'NumDoc' ( (lv_name_3_0= ruleQualifiedName ) ) ) ) )
            // InternalSephirah.g:197:2: ( (otherlv_0= 'SephirahDoc' ( (lv_name_1_0= ruleQualifiedName ) ) ) | (otherlv_2= 'NumDoc' ( (lv_name_3_0= ruleQualifiedName ) ) ) )
            {
            // InternalSephirah.g:197:2: ( (otherlv_0= 'SephirahDoc' ( (lv_name_1_0= ruleQualifiedName ) ) ) | (otherlv_2= 'NumDoc' ( (lv_name_3_0= ruleQualifiedName ) ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==12) ) {
                alt4=1;
            }
            else if ( (LA4_0==13) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalSephirah.g:198:3: (otherlv_0= 'SephirahDoc' ( (lv_name_1_0= ruleQualifiedName ) ) )
                    {
                    // InternalSephirah.g:198:3: (otherlv_0= 'SephirahDoc' ( (lv_name_1_0= ruleQualifiedName ) ) )
                    // InternalSephirah.g:199:4: otherlv_0= 'SephirahDoc' ( (lv_name_1_0= ruleQualifiedName ) )
                    {
                    otherlv_0=(Token)match(input,12,FOLLOW_5); 

                    				newLeafNode(otherlv_0, grammarAccess.getDocNameAccess().getSephirahDocKeyword_0_0());
                    			
                    // InternalSephirah.g:203:4: ( (lv_name_1_0= ruleQualifiedName ) )
                    // InternalSephirah.g:204:5: (lv_name_1_0= ruleQualifiedName )
                    {
                    // InternalSephirah.g:204:5: (lv_name_1_0= ruleQualifiedName )
                    // InternalSephirah.g:205:6: lv_name_1_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getDocNameAccess().getNameQualifiedNameParserRuleCall_0_1_0());
                    					
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
                    break;
                case 2 :
                    // InternalSephirah.g:224:3: (otherlv_2= 'NumDoc' ( (lv_name_3_0= ruleQualifiedName ) ) )
                    {
                    // InternalSephirah.g:224:3: (otherlv_2= 'NumDoc' ( (lv_name_3_0= ruleQualifiedName ) ) )
                    // InternalSephirah.g:225:4: otherlv_2= 'NumDoc' ( (lv_name_3_0= ruleQualifiedName ) )
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_5); 

                    				newLeafNode(otherlv_2, grammarAccess.getDocNameAccess().getNumDocKeyword_1_0());
                    			
                    // InternalSephirah.g:229:4: ( (lv_name_3_0= ruleQualifiedName ) )
                    // InternalSephirah.g:230:5: (lv_name_3_0= ruleQualifiedName )
                    {
                    // InternalSephirah.g:230:5: (lv_name_3_0= ruleQualifiedName )
                    // InternalSephirah.g:231:6: lv_name_3_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getDocNameAccess().getNameQualifiedNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_name_3_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDocNameRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_3_0,
                    							"com.fearlesstyrant.sephirah.Sephirah.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


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
    // $ANTLR end "ruleDocName"


    // $ANTLR start "entryRuleImport"
    // InternalSephirah.g:253:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalSephirah.g:253:47: (iv_ruleImport= ruleImport EOF )
            // InternalSephirah.g:254:2: iv_ruleImport= ruleImport EOF
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
    // InternalSephirah.g:260:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_module_1_0= ruleQualifiedName ) ) (otherlv_2= 'as' ( (lv_alias_3_0= ruleValidID ) ) )? otherlv_4= ';' ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_module_1_0 = null;

        AntlrDatatypeRuleToken lv_alias_3_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:266:2: ( (otherlv_0= 'import' ( (lv_module_1_0= ruleQualifiedName ) ) (otherlv_2= 'as' ( (lv_alias_3_0= ruleValidID ) ) )? otherlv_4= ';' ) )
            // InternalSephirah.g:267:2: (otherlv_0= 'import' ( (lv_module_1_0= ruleQualifiedName ) ) (otherlv_2= 'as' ( (lv_alias_3_0= ruleValidID ) ) )? otherlv_4= ';' )
            {
            // InternalSephirah.g:267:2: (otherlv_0= 'import' ( (lv_module_1_0= ruleQualifiedName ) ) (otherlv_2= 'as' ( (lv_alias_3_0= ruleValidID ) ) )? otherlv_4= ';' )
            // InternalSephirah.g:268:3: otherlv_0= 'import' ( (lv_module_1_0= ruleQualifiedName ) ) (otherlv_2= 'as' ( (lv_alias_3_0= ruleValidID ) ) )? otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,14,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalSephirah.g:272:3: ( (lv_module_1_0= ruleQualifiedName ) )
            // InternalSephirah.g:273:4: (lv_module_1_0= ruleQualifiedName )
            {
            // InternalSephirah.g:273:4: (lv_module_1_0= ruleQualifiedName )
            // InternalSephirah.g:274:5: lv_module_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getImportAccess().getModuleQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_6);
            lv_module_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getImportRule());
            					}
            					set(
            						current,
            						"module",
            						lv_module_1_0,
            						"com.fearlesstyrant.sephirah.Sephirah.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSephirah.g:291:3: (otherlv_2= 'as' ( (lv_alias_3_0= ruleValidID ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalSephirah.g:292:4: otherlv_2= 'as' ( (lv_alias_3_0= ruleValidID ) )
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_5); 

                    				newLeafNode(otherlv_2, grammarAccess.getImportAccess().getAsKeyword_2_0());
                    			
                    // InternalSephirah.g:296:4: ( (lv_alias_3_0= ruleValidID ) )
                    // InternalSephirah.g:297:5: (lv_alias_3_0= ruleValidID )
                    {
                    // InternalSephirah.g:297:5: (lv_alias_3_0= ruleValidID )
                    // InternalSephirah.g:298:6: lv_alias_3_0= ruleValidID
                    {

                    						newCompositeNode(grammarAccess.getImportAccess().getAliasValidIDParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_alias_3_0=ruleValidID();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getImportRule());
                    						}
                    						set(
                    							current,
                    							"alias",
                    							lv_alias_3_0,
                    							"com.fearlesstyrant.sephirah.Sephirah.ValidID");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getImportAccess().getSemicolonKeyword_3());
            		

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
    // InternalSephirah.g:324:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // InternalSephirah.g:324:51: (iv_ruleDefinition= ruleDefinition EOF )
            // InternalSephirah.g:325:2: iv_ruleDefinition= ruleDefinition EOF
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
    // InternalSephirah.g:331:1: ruleDefinition returns [EObject current=null] : (otherlv_0= 'def' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )* )? otherlv_6= ')' otherlv_7= '=' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';' ) ;
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
            // InternalSephirah.g:337:2: ( (otherlv_0= 'def' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )* )? otherlv_6= ')' otherlv_7= '=' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';' ) )
            // InternalSephirah.g:338:2: (otherlv_0= 'def' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )* )? otherlv_6= ')' otherlv_7= '=' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';' )
            {
            // InternalSephirah.g:338:2: (otherlv_0= 'def' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )* )? otherlv_6= ')' otherlv_7= '=' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';' )
            // InternalSephirah.g:339:3: otherlv_0= 'def' ( (lv_name_1_0= ruleValidID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )* )? otherlv_6= ')' otherlv_7= '=' ( (lv_expr_8_0= ruleExpression ) ) otherlv_9= ';'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getDefinitionAccess().getDefKeyword_0());
            		
            // InternalSephirah.g:343:3: ( (lv_name_1_0= ruleValidID ) )
            // InternalSephirah.g:344:4: (lv_name_1_0= ruleValidID )
            {
            // InternalSephirah.g:344:4: (lv_name_1_0= ruleValidID )
            // InternalSephirah.g:345:5: lv_name_1_0= ruleValidID
            {

            					newCompositeNode(grammarAccess.getDefinitionAccess().getNameValidIDParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_8);
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

            otherlv_2=(Token)match(input,18,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_2());
            		
            // InternalSephirah.g:366:3: ( ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_ID && LA7_0<=RULE_ESCAPED_ID)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalSephirah.g:367:4: ( (lv_args_3_0= ruleDefinitionVariable ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )*
                    {
                    // InternalSephirah.g:367:4: ( (lv_args_3_0= ruleDefinitionVariable ) )
                    // InternalSephirah.g:368:5: (lv_args_3_0= ruleDefinitionVariable )
                    {
                    // InternalSephirah.g:368:5: (lv_args_3_0= ruleDefinitionVariable )
                    // InternalSephirah.g:369:6: lv_args_3_0= ruleDefinitionVariable
                    {

                    						newCompositeNode(grammarAccess.getDefinitionAccess().getArgsDefinitionVariableParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_10);
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

                    // InternalSephirah.g:386:4: (otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==19) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalSephirah.g:387:5: otherlv_4= ',' ( (lv_args_5_0= ruleDefinitionVariable ) )
                    	    {
                    	    otherlv_4=(Token)match(input,19,FOLLOW_5); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getDefinitionAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalSephirah.g:391:5: ( (lv_args_5_0= ruleDefinitionVariable ) )
                    	    // InternalSephirah.g:392:6: (lv_args_5_0= ruleDefinitionVariable )
                    	    {
                    	    // InternalSephirah.g:392:6: (lv_args_5_0= ruleDefinitionVariable )
                    	    // InternalSephirah.g:393:7: lv_args_5_0= ruleDefinitionVariable
                    	    {

                    	    							newCompositeNode(grammarAccess.getDefinitionAccess().getArgsDefinitionVariableParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_10);
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

            otherlv_6=(Token)match(input,20,FOLLOW_11); 

            			newLeafNode(otherlv_6, grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_4());
            		
            otherlv_7=(Token)match(input,21,FOLLOW_12); 

            			newLeafNode(otherlv_7, grammarAccess.getDefinitionAccess().getEqualsSignKeyword_5());
            		
            // InternalSephirah.g:420:3: ( (lv_expr_8_0= ruleExpression ) )
            // InternalSephirah.g:421:4: (lv_expr_8_0= ruleExpression )
            {
            // InternalSephirah.g:421:4: (lv_expr_8_0= ruleExpression )
            // InternalSephirah.g:422:5: lv_expr_8_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getDefinitionAccess().getExprExpressionParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_7);
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

            otherlv_9=(Token)match(input,16,FOLLOW_2); 

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
    // InternalSephirah.g:447:1: entryRuleVariableAssignment returns [EObject current=null] : iv_ruleVariableAssignment= ruleVariableAssignment EOF ;
    public final EObject entryRuleVariableAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableAssignment = null;


        try {
            // InternalSephirah.g:447:59: (iv_ruleVariableAssignment= ruleVariableAssignment EOF )
            // InternalSephirah.g:448:2: iv_ruleVariableAssignment= ruleVariableAssignment EOF
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
    // InternalSephirah.g:454:1: ruleVariableAssignment returns [EObject current=null] : ( () otherlv_1= 'var' ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' ) ;
    public final EObject ruleVariableAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:460:2: ( ( () otherlv_1= 'var' ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' ) )
            // InternalSephirah.g:461:2: ( () otherlv_1= 'var' ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' )
            {
            // InternalSephirah.g:461:2: ( () otherlv_1= 'var' ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' )
            // InternalSephirah.g:462:3: () otherlv_1= 'var' ( (lv_name_2_0= ruleValidID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';'
            {
            // InternalSephirah.g:462:3: ()
            // InternalSephirah.g:463:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVariableAssignmentAccess().getVariableAssignmentAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,22,FOLLOW_5); 

            			newLeafNode(otherlv_1, grammarAccess.getVariableAssignmentAccess().getVarKeyword_1());
            		
            // InternalSephirah.g:473:3: ( (lv_name_2_0= ruleValidID ) )
            // InternalSephirah.g:474:4: (lv_name_2_0= ruleValidID )
            {
            // InternalSephirah.g:474:4: (lv_name_2_0= ruleValidID )
            // InternalSephirah.g:475:5: lv_name_2_0= ruleValidID
            {

            					newCompositeNode(grammarAccess.getVariableAssignmentAccess().getNameValidIDParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_11);
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

            otherlv_3=(Token)match(input,21,FOLLOW_12); 

            			newLeafNode(otherlv_3, grammarAccess.getVariableAssignmentAccess().getEqualsSignKeyword_3());
            		
            // InternalSephirah.g:496:3: ( (lv_value_4_0= ruleExpression ) )
            // InternalSephirah.g:497:4: (lv_value_4_0= ruleExpression )
            {
            // InternalSephirah.g:497:4: (lv_value_4_0= ruleExpression )
            // InternalSephirah.g:498:5: lv_value_4_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getVariableAssignmentAccess().getValueExpressionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_7);
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

            otherlv_5=(Token)match(input,16,FOLLOW_2); 

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
    // InternalSephirah.g:523:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalSephirah.g:523:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalSephirah.g:524:2: iv_ruleVariable= ruleVariable EOF
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
    // InternalSephirah.g:530:1: ruleVariable returns [EObject current=null] : ( () ( (lv_name_1_0= ruleQualifiedName ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:536:2: ( ( () ( (lv_name_1_0= ruleQualifiedName ) ) ) )
            // InternalSephirah.g:537:2: ( () ( (lv_name_1_0= ruleQualifiedName ) ) )
            {
            // InternalSephirah.g:537:2: ( () ( (lv_name_1_0= ruleQualifiedName ) ) )
            // InternalSephirah.g:538:3: () ( (lv_name_1_0= ruleQualifiedName ) )
            {
            // InternalSephirah.g:538:3: ()
            // InternalSephirah.g:539:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVariableAccess().getVariableAction_0(),
            					current);
            			

            }

            // InternalSephirah.g:545:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalSephirah.g:546:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalSephirah.g:546:4: (lv_name_1_0= ruleQualifiedName )
            // InternalSephirah.g:547:5: lv_name_1_0= ruleQualifiedName
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
    // InternalSephirah.g:568:1: entryRuleDefinitionVariable returns [EObject current=null] : iv_ruleDefinitionVariable= ruleDefinitionVariable EOF ;
    public final EObject entryRuleDefinitionVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinitionVariable = null;


        try {
            // InternalSephirah.g:568:59: (iv_ruleDefinitionVariable= ruleDefinitionVariable EOF )
            // InternalSephirah.g:569:2: iv_ruleDefinitionVariable= ruleDefinitionVariable EOF
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
    // InternalSephirah.g:575:1: ruleDefinitionVariable returns [EObject current=null] : ( () ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleDefinitionVariable() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:581:2: ( ( () ( (lv_name_1_0= ruleValidID ) ) ) )
            // InternalSephirah.g:582:2: ( () ( (lv_name_1_0= ruleValidID ) ) )
            {
            // InternalSephirah.g:582:2: ( () ( (lv_name_1_0= ruleValidID ) ) )
            // InternalSephirah.g:583:3: () ( (lv_name_1_0= ruleValidID ) )
            {
            // InternalSephirah.g:583:3: ()
            // InternalSephirah.g:584:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDefinitionVariableAccess().getDefinitionVariableAction_0(),
            					current);
            			

            }

            // InternalSephirah.g:590:3: ( (lv_name_1_0= ruleValidID ) )
            // InternalSephirah.g:591:4: (lv_name_1_0= ruleValidID )
            {
            // InternalSephirah.g:591:4: (lv_name_1_0= ruleValidID )
            // InternalSephirah.g:592:5: lv_name_1_0= ruleValidID
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
    // InternalSephirah.g:613:1: entryRuleEvaluation returns [EObject current=null] : iv_ruleEvaluation= ruleEvaluation EOF ;
    public final EObject entryRuleEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvaluation = null;


        try {
            // InternalSephirah.g:613:51: (iv_ruleEvaluation= ruleEvaluation EOF )
            // InternalSephirah.g:614:2: iv_ruleEvaluation= ruleEvaluation EOF
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
    // InternalSephirah.g:620:1: ruleEvaluation returns [EObject current=null] : ( ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';' ) ;
    public final EObject ruleEvaluation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_0_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:626:2: ( ( ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';' ) )
            // InternalSephirah.g:627:2: ( ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';' )
            {
            // InternalSephirah.g:627:2: ( ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';' )
            // InternalSephirah.g:628:3: ( (lv_expression_0_0= ruleExpression ) ) otherlv_1= ';'
            {
            // InternalSephirah.g:628:3: ( (lv_expression_0_0= ruleExpression ) )
            // InternalSephirah.g:629:4: (lv_expression_0_0= ruleExpression )
            {
            // InternalSephirah.g:629:4: (lv_expression_0_0= ruleExpression )
            // InternalSephirah.g:630:5: lv_expression_0_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getEvaluationAccess().getExpressionExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
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

            otherlv_1=(Token)match(input,16,FOLLOW_2); 

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
    // InternalSephirah.g:655:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalSephirah.g:655:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalSephirah.g:656:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalSephirah.g:662:1: ruleExpression returns [EObject current=null] : this_ConditionalExpression_0= ruleConditionalExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ConditionalExpression_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:668:2: (this_ConditionalExpression_0= ruleConditionalExpression )
            // InternalSephirah.g:669:2: this_ConditionalExpression_0= ruleConditionalExpression
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
    // InternalSephirah.g:680:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // InternalSephirah.g:680:62: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // InternalSephirah.g:681:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
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
    // InternalSephirah.g:687:1: ruleConditionalExpression returns [EObject current=null] : ( ( () otherlv_1= 'if' ( (lv_condition_2_0= ruleBooleanExpression ) ) otherlv_3= 'then' ( (lv_thenBranch_4_0= ruleExpression ) ) otherlv_5= 'else' ( (lv_elseBranch_6_0= ruleExpression ) ) ) | this_BooleanExpression_7= ruleBooleanExpression ) ;
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
            // InternalSephirah.g:693:2: ( ( ( () otherlv_1= 'if' ( (lv_condition_2_0= ruleBooleanExpression ) ) otherlv_3= 'then' ( (lv_thenBranch_4_0= ruleExpression ) ) otherlv_5= 'else' ( (lv_elseBranch_6_0= ruleExpression ) ) ) | this_BooleanExpression_7= ruleBooleanExpression ) )
            // InternalSephirah.g:694:2: ( ( () otherlv_1= 'if' ( (lv_condition_2_0= ruleBooleanExpression ) ) otherlv_3= 'then' ( (lv_thenBranch_4_0= ruleExpression ) ) otherlv_5= 'else' ( (lv_elseBranch_6_0= ruleExpression ) ) ) | this_BooleanExpression_7= ruleBooleanExpression )
            {
            // InternalSephirah.g:694:2: ( ( () otherlv_1= 'if' ( (lv_condition_2_0= ruleBooleanExpression ) ) otherlv_3= 'then' ( (lv_thenBranch_4_0= ruleExpression ) ) otherlv_5= 'else' ( (lv_elseBranch_6_0= ruleExpression ) ) ) | this_BooleanExpression_7= ruleBooleanExpression )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==23) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=RULE_ID && LA8_0<=RULE_INT)||LA8_0==18||(LA8_0>=28 && LA8_0<=29)||LA8_0==32||(LA8_0>=36 && LA8_0<=42)) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalSephirah.g:695:3: ( () otherlv_1= 'if' ( (lv_condition_2_0= ruleBooleanExpression ) ) otherlv_3= 'then' ( (lv_thenBranch_4_0= ruleExpression ) ) otherlv_5= 'else' ( (lv_elseBranch_6_0= ruleExpression ) ) )
                    {
                    // InternalSephirah.g:695:3: ( () otherlv_1= 'if' ( (lv_condition_2_0= ruleBooleanExpression ) ) otherlv_3= 'then' ( (lv_thenBranch_4_0= ruleExpression ) ) otherlv_5= 'else' ( (lv_elseBranch_6_0= ruleExpression ) ) )
                    // InternalSephirah.g:696:4: () otherlv_1= 'if' ( (lv_condition_2_0= ruleBooleanExpression ) ) otherlv_3= 'then' ( (lv_thenBranch_4_0= ruleExpression ) ) otherlv_5= 'else' ( (lv_elseBranch_6_0= ruleExpression ) )
                    {
                    // InternalSephirah.g:696:4: ()
                    // InternalSephirah.g:697:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getConditionalExpressionAccess().getConditionalAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,23,FOLLOW_12); 

                    				newLeafNode(otherlv_1, grammarAccess.getConditionalExpressionAccess().getIfKeyword_0_1());
                    			
                    // InternalSephirah.g:707:4: ( (lv_condition_2_0= ruleBooleanExpression ) )
                    // InternalSephirah.g:708:5: (lv_condition_2_0= ruleBooleanExpression )
                    {
                    // InternalSephirah.g:708:5: (lv_condition_2_0= ruleBooleanExpression )
                    // InternalSephirah.g:709:6: lv_condition_2_0= ruleBooleanExpression
                    {

                    						newCompositeNode(grammarAccess.getConditionalExpressionAccess().getConditionBooleanExpressionParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_13);
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

                    otherlv_3=(Token)match(input,24,FOLLOW_12); 

                    				newLeafNode(otherlv_3, grammarAccess.getConditionalExpressionAccess().getThenKeyword_0_3());
                    			
                    // InternalSephirah.g:730:4: ( (lv_thenBranch_4_0= ruleExpression ) )
                    // InternalSephirah.g:731:5: (lv_thenBranch_4_0= ruleExpression )
                    {
                    // InternalSephirah.g:731:5: (lv_thenBranch_4_0= ruleExpression )
                    // InternalSephirah.g:732:6: lv_thenBranch_4_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getConditionalExpressionAccess().getThenBranchExpressionParserRuleCall_0_4_0());
                    					
                    pushFollow(FOLLOW_14);
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

                    otherlv_5=(Token)match(input,25,FOLLOW_12); 

                    				newLeafNode(otherlv_5, grammarAccess.getConditionalExpressionAccess().getElseKeyword_0_5());
                    			
                    // InternalSephirah.g:753:4: ( (lv_elseBranch_6_0= ruleExpression ) )
                    // InternalSephirah.g:754:5: (lv_elseBranch_6_0= ruleExpression )
                    {
                    // InternalSephirah.g:754:5: (lv_elseBranch_6_0= ruleExpression )
                    // InternalSephirah.g:755:6: lv_elseBranch_6_0= ruleExpression
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
                    // InternalSephirah.g:774:3: this_BooleanExpression_7= ruleBooleanExpression
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
    // InternalSephirah.g:786:1: entryRuleBooleanExpression returns [EObject current=null] : iv_ruleBooleanExpression= ruleBooleanExpression EOF ;
    public final EObject entryRuleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanExpression = null;


        try {
            // InternalSephirah.g:786:58: (iv_ruleBooleanExpression= ruleBooleanExpression EOF )
            // InternalSephirah.g:787:2: iv_ruleBooleanExpression= ruleBooleanExpression EOF
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
    // InternalSephirah.g:793:1: ruleBooleanExpression returns [EObject current=null] : this_OrBooleanExpression_0= ruleOrBooleanExpression ;
    public final EObject ruleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject this_OrBooleanExpression_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:799:2: (this_OrBooleanExpression_0= ruleOrBooleanExpression )
            // InternalSephirah.g:800:2: this_OrBooleanExpression_0= ruleOrBooleanExpression
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
    // InternalSephirah.g:811:1: entryRuleOrBooleanExpression returns [EObject current=null] : iv_ruleOrBooleanExpression= ruleOrBooleanExpression EOF ;
    public final EObject entryRuleOrBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrBooleanExpression = null;


        try {
            // InternalSephirah.g:811:60: (iv_ruleOrBooleanExpression= ruleOrBooleanExpression EOF )
            // InternalSephirah.g:812:2: iv_ruleOrBooleanExpression= ruleOrBooleanExpression EOF
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
    // InternalSephirah.g:818:1: ruleOrBooleanExpression returns [EObject current=null] : (this_AndBooleanExpression_0= ruleAndBooleanExpression ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndBooleanExpression ) ) )* ) ;
    public final EObject ruleOrBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndBooleanExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:824:2: ( (this_AndBooleanExpression_0= ruleAndBooleanExpression ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndBooleanExpression ) ) )* ) )
            // InternalSephirah.g:825:2: (this_AndBooleanExpression_0= ruleAndBooleanExpression ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndBooleanExpression ) ) )* )
            {
            // InternalSephirah.g:825:2: (this_AndBooleanExpression_0= ruleAndBooleanExpression ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndBooleanExpression ) ) )* )
            // InternalSephirah.g:826:3: this_AndBooleanExpression_0= ruleAndBooleanExpression ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndBooleanExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrBooleanExpressionAccess().getAndBooleanExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_15);
            this_AndBooleanExpression_0=ruleAndBooleanExpression();

            state._fsp--;


            			current = this_AndBooleanExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSephirah.g:834:3: ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndBooleanExpression ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==26) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalSephirah.g:835:4: () otherlv_2= 'or' ( (lv_right_3_0= ruleAndBooleanExpression ) )
            	    {
            	    // InternalSephirah.g:835:4: ()
            	    // InternalSephirah.g:836:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getOrBooleanExpressionAccess().getOrConditionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,26,FOLLOW_12); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOrBooleanExpressionAccess().getOrKeyword_1_1());
            	    			
            	    // InternalSephirah.g:846:4: ( (lv_right_3_0= ruleAndBooleanExpression ) )
            	    // InternalSephirah.g:847:5: (lv_right_3_0= ruleAndBooleanExpression )
            	    {
            	    // InternalSephirah.g:847:5: (lv_right_3_0= ruleAndBooleanExpression )
            	    // InternalSephirah.g:848:6: lv_right_3_0= ruleAndBooleanExpression
            	    {

            	    						newCompositeNode(grammarAccess.getOrBooleanExpressionAccess().getRightAndBooleanExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_15);
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
    // $ANTLR end "ruleOrBooleanExpression"


    // $ANTLR start "entryRuleAndBooleanExpression"
    // InternalSephirah.g:870:1: entryRuleAndBooleanExpression returns [EObject current=null] : iv_ruleAndBooleanExpression= ruleAndBooleanExpression EOF ;
    public final EObject entryRuleAndBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndBooleanExpression = null;


        try {
            // InternalSephirah.g:870:61: (iv_ruleAndBooleanExpression= ruleAndBooleanExpression EOF )
            // InternalSephirah.g:871:2: iv_ruleAndBooleanExpression= ruleAndBooleanExpression EOF
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
    // InternalSephirah.g:877:1: ruleAndBooleanExpression returns [EObject current=null] : (this_NotBooleanExpression_0= ruleNotBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleNotBooleanExpression ) ) )* ) ;
    public final EObject ruleAndBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_NotBooleanExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:883:2: ( (this_NotBooleanExpression_0= ruleNotBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleNotBooleanExpression ) ) )* ) )
            // InternalSephirah.g:884:2: (this_NotBooleanExpression_0= ruleNotBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleNotBooleanExpression ) ) )* )
            {
            // InternalSephirah.g:884:2: (this_NotBooleanExpression_0= ruleNotBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleNotBooleanExpression ) ) )* )
            // InternalSephirah.g:885:3: this_NotBooleanExpression_0= ruleNotBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleNotBooleanExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndBooleanExpressionAccess().getNotBooleanExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_16);
            this_NotBooleanExpression_0=ruleNotBooleanExpression();

            state._fsp--;


            			current = this_NotBooleanExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSephirah.g:893:3: ( () otherlv_2= 'and' ( (lv_right_3_0= ruleNotBooleanExpression ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==27) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalSephirah.g:894:4: () otherlv_2= 'and' ( (lv_right_3_0= ruleNotBooleanExpression ) )
            	    {
            	    // InternalSephirah.g:894:4: ()
            	    // InternalSephirah.g:895:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndBooleanExpressionAccess().getAndConditionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,27,FOLLOW_12); 

            	    				newLeafNode(otherlv_2, grammarAccess.getAndBooleanExpressionAccess().getAndKeyword_1_1());
            	    			
            	    // InternalSephirah.g:905:4: ( (lv_right_3_0= ruleNotBooleanExpression ) )
            	    // InternalSephirah.g:906:5: (lv_right_3_0= ruleNotBooleanExpression )
            	    {
            	    // InternalSephirah.g:906:5: (lv_right_3_0= ruleNotBooleanExpression )
            	    // InternalSephirah.g:907:6: lv_right_3_0= ruleNotBooleanExpression
            	    {

            	    						newCompositeNode(grammarAccess.getAndBooleanExpressionAccess().getRightNotBooleanExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_16);
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
    // $ANTLR end "ruleAndBooleanExpression"


    // $ANTLR start "entryRuleNotBooleanExpression"
    // InternalSephirah.g:929:1: entryRuleNotBooleanExpression returns [EObject current=null] : iv_ruleNotBooleanExpression= ruleNotBooleanExpression EOF ;
    public final EObject entryRuleNotBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotBooleanExpression = null;


        try {
            // InternalSephirah.g:929:61: (iv_ruleNotBooleanExpression= ruleNotBooleanExpression EOF )
            // InternalSephirah.g:930:2: iv_ruleNotBooleanExpression= ruleNotBooleanExpression EOF
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
    // InternalSephirah.g:936:1: ruleNotBooleanExpression returns [EObject current=null] : ( ( () otherlv_1= 'not' ( (lv_condition_2_0= ruleNotBooleanExpression ) ) ) | this_PrimaryBooleanExpression_3= rulePrimaryBooleanExpression ) ;
    public final EObject ruleNotBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_condition_2_0 = null;

        EObject this_PrimaryBooleanExpression_3 = null;



        	enterRule();

        try {
            // InternalSephirah.g:942:2: ( ( ( () otherlv_1= 'not' ( (lv_condition_2_0= ruleNotBooleanExpression ) ) ) | this_PrimaryBooleanExpression_3= rulePrimaryBooleanExpression ) )
            // InternalSephirah.g:943:2: ( ( () otherlv_1= 'not' ( (lv_condition_2_0= ruleNotBooleanExpression ) ) ) | this_PrimaryBooleanExpression_3= rulePrimaryBooleanExpression )
            {
            // InternalSephirah.g:943:2: ( ( () otherlv_1= 'not' ( (lv_condition_2_0= ruleNotBooleanExpression ) ) ) | this_PrimaryBooleanExpression_3= rulePrimaryBooleanExpression )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==28) ) {
                alt11=1;
            }
            else if ( ((LA11_0>=RULE_ID && LA11_0<=RULE_INT)||LA11_0==18||LA11_0==29||LA11_0==32||(LA11_0>=36 && LA11_0<=42)) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalSephirah.g:944:3: ( () otherlv_1= 'not' ( (lv_condition_2_0= ruleNotBooleanExpression ) ) )
                    {
                    // InternalSephirah.g:944:3: ( () otherlv_1= 'not' ( (lv_condition_2_0= ruleNotBooleanExpression ) ) )
                    // InternalSephirah.g:945:4: () otherlv_1= 'not' ( (lv_condition_2_0= ruleNotBooleanExpression ) )
                    {
                    // InternalSephirah.g:945:4: ()
                    // InternalSephirah.g:946:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getNotBooleanExpressionAccess().getNotConditionAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,28,FOLLOW_12); 

                    				newLeafNode(otherlv_1, grammarAccess.getNotBooleanExpressionAccess().getNotKeyword_0_1());
                    			
                    // InternalSephirah.g:956:4: ( (lv_condition_2_0= ruleNotBooleanExpression ) )
                    // InternalSephirah.g:957:5: (lv_condition_2_0= ruleNotBooleanExpression )
                    {
                    // InternalSephirah.g:957:5: (lv_condition_2_0= ruleNotBooleanExpression )
                    // InternalSephirah.g:958:6: lv_condition_2_0= ruleNotBooleanExpression
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
                    // InternalSephirah.g:977:3: this_PrimaryBooleanExpression_3= rulePrimaryBooleanExpression
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
    // InternalSephirah.g:989:1: entryRulePrimaryBooleanExpression returns [EObject current=null] : iv_rulePrimaryBooleanExpression= rulePrimaryBooleanExpression EOF ;
    public final EObject entryRulePrimaryBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryBooleanExpression = null;


        try {
            // InternalSephirah.g:989:65: (iv_rulePrimaryBooleanExpression= rulePrimaryBooleanExpression EOF )
            // InternalSephirah.g:990:2: iv_rulePrimaryBooleanExpression= rulePrimaryBooleanExpression EOF
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
    // InternalSephirah.g:996:1: rulePrimaryBooleanExpression returns [EObject current=null] : ( (otherlv_0= '[' this_BooleanExpression_1= ruleBooleanExpression otherlv_2= ']' ) | (this_Addition_3= ruleAddition ( () ( (lv_op_5_0= ruleComparisonOperator ) ) ( (lv_right_6_0= ruleAddition ) ) )? ) ) ;
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
            // InternalSephirah.g:1002:2: ( ( (otherlv_0= '[' this_BooleanExpression_1= ruleBooleanExpression otherlv_2= ']' ) | (this_Addition_3= ruleAddition ( () ( (lv_op_5_0= ruleComparisonOperator ) ) ( (lv_right_6_0= ruleAddition ) ) )? ) ) )
            // InternalSephirah.g:1003:2: ( (otherlv_0= '[' this_BooleanExpression_1= ruleBooleanExpression otherlv_2= ']' ) | (this_Addition_3= ruleAddition ( () ( (lv_op_5_0= ruleComparisonOperator ) ) ( (lv_right_6_0= ruleAddition ) ) )? ) )
            {
            // InternalSephirah.g:1003:2: ( (otherlv_0= '[' this_BooleanExpression_1= ruleBooleanExpression otherlv_2= ']' ) | (this_Addition_3= ruleAddition ( () ( (lv_op_5_0= ruleComparisonOperator ) ) ( (lv_right_6_0= ruleAddition ) ) )? ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==29) ) {
                alt13=1;
            }
            else if ( ((LA13_0>=RULE_ID && LA13_0<=RULE_INT)||LA13_0==18||LA13_0==32||(LA13_0>=36 && LA13_0<=42)) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalSephirah.g:1004:3: (otherlv_0= '[' this_BooleanExpression_1= ruleBooleanExpression otherlv_2= ']' )
                    {
                    // InternalSephirah.g:1004:3: (otherlv_0= '[' this_BooleanExpression_1= ruleBooleanExpression otherlv_2= ']' )
                    // InternalSephirah.g:1005:4: otherlv_0= '[' this_BooleanExpression_1= ruleBooleanExpression otherlv_2= ']'
                    {
                    otherlv_0=(Token)match(input,29,FOLLOW_12); 

                    				newLeafNode(otherlv_0, grammarAccess.getPrimaryBooleanExpressionAccess().getLeftSquareBracketKeyword_0_0());
                    			

                    				newCompositeNode(grammarAccess.getPrimaryBooleanExpressionAccess().getBooleanExpressionParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_17);
                    this_BooleanExpression_1=ruleBooleanExpression();

                    state._fsp--;


                    				current = this_BooleanExpression_1;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_2=(Token)match(input,30,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getPrimaryBooleanExpressionAccess().getRightSquareBracketKeyword_0_2());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSephirah.g:1023:3: (this_Addition_3= ruleAddition ( () ( (lv_op_5_0= ruleComparisonOperator ) ) ( (lv_right_6_0= ruleAddition ) ) )? )
                    {
                    // InternalSephirah.g:1023:3: (this_Addition_3= ruleAddition ( () ( (lv_op_5_0= ruleComparisonOperator ) ) ( (lv_right_6_0= ruleAddition ) ) )? )
                    // InternalSephirah.g:1024:4: this_Addition_3= ruleAddition ( () ( (lv_op_5_0= ruleComparisonOperator ) ) ( (lv_right_6_0= ruleAddition ) ) )?
                    {

                    				newCompositeNode(grammarAccess.getPrimaryBooleanExpressionAccess().getAdditionParserRuleCall_1_0());
                    			
                    pushFollow(FOLLOW_18);
                    this_Addition_3=ruleAddition();

                    state._fsp--;


                    				current = this_Addition_3;
                    				afterParserOrEnumRuleCall();
                    			
                    // InternalSephirah.g:1032:4: ( () ( (lv_op_5_0= ruleComparisonOperator ) ) ( (lv_right_6_0= ruleAddition ) ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( ((LA12_0>=44 && LA12_0<=49)) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalSephirah.g:1033:5: () ( (lv_op_5_0= ruleComparisonOperator ) ) ( (lv_right_6_0= ruleAddition ) )
                            {
                            // InternalSephirah.g:1033:5: ()
                            // InternalSephirah.g:1034:6: 
                            {

                            						current = forceCreateModelElementAndSet(
                            							grammarAccess.getPrimaryBooleanExpressionAccess().getComparisonConditionLeftAction_1_1_0(),
                            							current);
                            					

                            }

                            // InternalSephirah.g:1040:5: ( (lv_op_5_0= ruleComparisonOperator ) )
                            // InternalSephirah.g:1041:6: (lv_op_5_0= ruleComparisonOperator )
                            {
                            // InternalSephirah.g:1041:6: (lv_op_5_0= ruleComparisonOperator )
                            // InternalSephirah.g:1042:7: lv_op_5_0= ruleComparisonOperator
                            {

                            							newCompositeNode(grammarAccess.getPrimaryBooleanExpressionAccess().getOpComparisonOperatorEnumRuleCall_1_1_1_0());
                            						
                            pushFollow(FOLLOW_12);
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

                            // InternalSephirah.g:1059:5: ( (lv_right_6_0= ruleAddition ) )
                            // InternalSephirah.g:1060:6: (lv_right_6_0= ruleAddition )
                            {
                            // InternalSephirah.g:1060:6: (lv_right_6_0= ruleAddition )
                            // InternalSephirah.g:1061:7: lv_right_6_0= ruleAddition
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
    // InternalSephirah.g:1084:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // InternalSephirah.g:1084:49: (iv_ruleAddition= ruleAddition EOF )
            // InternalSephirah.g:1085:2: iv_ruleAddition= ruleAddition EOF
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
    // InternalSephirah.g:1091:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:1097:2: ( (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) )
            // InternalSephirah.g:1098:2: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            {
            // InternalSephirah.g:1098:2: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            // InternalSephirah.g:1099:3: this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            {

            			newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0());
            		
            pushFollow(FOLLOW_19);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;


            			current = this_Multiplication_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSephirah.g:1107:3: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=31 && LA15_0<=32)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalSephirah.g:1108:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) )
            	    {
            	    // InternalSephirah.g:1108:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
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
            	            // InternalSephirah.g:1109:5: ( () otherlv_2= '+' )
            	            {
            	            // InternalSephirah.g:1109:5: ( () otherlv_2= '+' )
            	            // InternalSephirah.g:1110:6: () otherlv_2= '+'
            	            {
            	            // InternalSephirah.g:1110:6: ()
            	            // InternalSephirah.g:1111:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getAdditionAccess().getAddLeftAction_1_0_0_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_2=(Token)match(input,31,FOLLOW_12); 

            	            						newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalSephirah.g:1123:5: ( () otherlv_4= '-' )
            	            {
            	            // InternalSephirah.g:1123:5: ( () otherlv_4= '-' )
            	            // InternalSephirah.g:1124:6: () otherlv_4= '-'
            	            {
            	            // InternalSephirah.g:1124:6: ()
            	            // InternalSephirah.g:1125:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getAdditionAccess().getSubtractLeftAction_1_0_1_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_4=(Token)match(input,32,FOLLOW_12); 

            	            						newLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalSephirah.g:1137:4: ( (lv_right_5_0= ruleMultiplication ) )
            	    // InternalSephirah.g:1138:5: (lv_right_5_0= ruleMultiplication )
            	    {
            	    // InternalSephirah.g:1138:5: (lv_right_5_0= ruleMultiplication )
            	    // InternalSephirah.g:1139:6: lv_right_5_0= ruleMultiplication
            	    {

            	    						newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_19);
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
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleMultiplication"
    // InternalSephirah.g:1161:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // InternalSephirah.g:1161:55: (iv_ruleMultiplication= ruleMultiplication EOF )
            // InternalSephirah.g:1162:2: iv_ruleMultiplication= ruleMultiplication EOF
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
    // InternalSephirah.g:1168:1: ruleMultiplication returns [EObject current=null] : (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleUnary ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Unary_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:1174:2: ( (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleUnary ) ) )* ) )
            // InternalSephirah.g:1175:2: (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleUnary ) ) )* )
            {
            // InternalSephirah.g:1175:2: (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleUnary ) ) )* )
            // InternalSephirah.g:1176:3: this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleUnary ) ) )*
            {

            			newCompositeNode(grammarAccess.getMultiplicationAccess().getUnaryParserRuleCall_0());
            		
            pushFollow(FOLLOW_20);
            this_Unary_0=ruleUnary();

            state._fsp--;


            			current = this_Unary_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSephirah.g:1184:3: ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleUnary ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=33 && LA17_0<=34)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalSephirah.g:1185:4: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) ) ( (lv_right_5_0= ruleUnary ) )
            	    {
            	    // InternalSephirah.g:1185:4: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) )
            	    int alt16=2;
            	    int LA16_0 = input.LA(1);

            	    if ( (LA16_0==33) ) {
            	        alt16=1;
            	    }
            	    else if ( (LA16_0==34) ) {
            	        alt16=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 16, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt16) {
            	        case 1 :
            	            // InternalSephirah.g:1186:5: ( () otherlv_2= '*' )
            	            {
            	            // InternalSephirah.g:1186:5: ( () otherlv_2= '*' )
            	            // InternalSephirah.g:1187:6: () otherlv_2= '*'
            	            {
            	            // InternalSephirah.g:1187:6: ()
            	            // InternalSephirah.g:1188:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getMultiplicationAccess().getMultiplyLeftAction_1_0_0_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_2=(Token)match(input,33,FOLLOW_12); 

            	            						newLeafNode(otherlv_2, grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0_1());
            	            					

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalSephirah.g:1200:5: ( () otherlv_4= '/' )
            	            {
            	            // InternalSephirah.g:1200:5: ( () otherlv_4= '/' )
            	            // InternalSephirah.g:1201:6: () otherlv_4= '/'
            	            {
            	            // InternalSephirah.g:1201:6: ()
            	            // InternalSephirah.g:1202:7: 
            	            {

            	            							current = forceCreateModelElementAndSet(
            	            								grammarAccess.getMultiplicationAccess().getDivideLeftAction_1_0_1_0(),
            	            								current);
            	            						

            	            }

            	            otherlv_4=(Token)match(input,34,FOLLOW_12); 

            	            						newLeafNode(otherlv_4, grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_0_1_1());
            	            					

            	            }


            	            }
            	            break;

            	    }

            	    // InternalSephirah.g:1214:4: ( (lv_right_5_0= ruleUnary ) )
            	    // InternalSephirah.g:1215:5: (lv_right_5_0= ruleUnary )
            	    {
            	    // InternalSephirah.g:1215:5: (lv_right_5_0= ruleUnary )
            	    // InternalSephirah.g:1216:6: lv_right_5_0= ruleUnary
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplicationAccess().getRightUnaryParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_20);
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
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRuleUnary"
    // InternalSephirah.g:1238:1: entryRuleUnary returns [EObject current=null] : iv_ruleUnary= ruleUnary EOF ;
    public final EObject entryRuleUnary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnary = null;


        try {
            // InternalSephirah.g:1238:46: (iv_ruleUnary= ruleUnary EOF )
            // InternalSephirah.g:1239:2: iv_ruleUnary= ruleUnary EOF
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
    // InternalSephirah.g:1245:1: ruleUnary returns [EObject current=null] : ( ( () otherlv_1= '-' ( (lv_value_2_0= ruleUnary ) ) ) | this_Exponent_3= ruleExponent ) ;
    public final EObject ruleUnary() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;

        EObject this_Exponent_3 = null;



        	enterRule();

        try {
            // InternalSephirah.g:1251:2: ( ( ( () otherlv_1= '-' ( (lv_value_2_0= ruleUnary ) ) ) | this_Exponent_3= ruleExponent ) )
            // InternalSephirah.g:1252:2: ( ( () otherlv_1= '-' ( (lv_value_2_0= ruleUnary ) ) ) | this_Exponent_3= ruleExponent )
            {
            // InternalSephirah.g:1252:2: ( ( () otherlv_1= '-' ( (lv_value_2_0= ruleUnary ) ) ) | this_Exponent_3= ruleExponent )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==32) ) {
                alt18=1;
            }
            else if ( ((LA18_0>=RULE_ID && LA18_0<=RULE_INT)||LA18_0==18||(LA18_0>=36 && LA18_0<=42)) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalSephirah.g:1253:3: ( () otherlv_1= '-' ( (lv_value_2_0= ruleUnary ) ) )
                    {
                    // InternalSephirah.g:1253:3: ( () otherlv_1= '-' ( (lv_value_2_0= ruleUnary ) ) )
                    // InternalSephirah.g:1254:4: () otherlv_1= '-' ( (lv_value_2_0= ruleUnary ) )
                    {
                    // InternalSephirah.g:1254:4: ()
                    // InternalSephirah.g:1255:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getUnaryAccess().getNegateAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,32,FOLLOW_12); 

                    				newLeafNode(otherlv_1, grammarAccess.getUnaryAccess().getHyphenMinusKeyword_0_1());
                    			
                    // InternalSephirah.g:1265:4: ( (lv_value_2_0= ruleUnary ) )
                    // InternalSephirah.g:1266:5: (lv_value_2_0= ruleUnary )
                    {
                    // InternalSephirah.g:1266:5: (lv_value_2_0= ruleUnary )
                    // InternalSephirah.g:1267:6: lv_value_2_0= ruleUnary
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
                    // InternalSephirah.g:1286:3: this_Exponent_3= ruleExponent
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
    // InternalSephirah.g:1298:1: entryRuleExponent returns [EObject current=null] : iv_ruleExponent= ruleExponent EOF ;
    public final EObject entryRuleExponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExponent = null;


        try {
            // InternalSephirah.g:1298:49: (iv_ruleExponent= ruleExponent EOF )
            // InternalSephirah.g:1299:2: iv_ruleExponent= ruleExponent EOF
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
    // InternalSephirah.g:1305:1: ruleExponent returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '^' ( (lv_right_3_0= ruleUnary ) ) )? ) ;
    public final EObject ruleExponent() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_PrimaryExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSephirah.g:1311:2: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '^' ( (lv_right_3_0= ruleUnary ) ) )? ) )
            // InternalSephirah.g:1312:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '^' ( (lv_right_3_0= ruleUnary ) ) )? )
            {
            // InternalSephirah.g:1312:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '^' ( (lv_right_3_0= ruleUnary ) ) )? )
            // InternalSephirah.g:1313:3: this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '^' ( (lv_right_3_0= ruleUnary ) ) )?
            {

            			newCompositeNode(grammarAccess.getExponentAccess().getPrimaryExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_21);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;


            			current = this_PrimaryExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalSephirah.g:1321:3: ( () otherlv_2= '^' ( (lv_right_3_0= ruleUnary ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==35) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalSephirah.g:1322:4: () otherlv_2= '^' ( (lv_right_3_0= ruleUnary ) )
                    {
                    // InternalSephirah.g:1322:4: ()
                    // InternalSephirah.g:1323:5: 
                    {

                    					current = forceCreateModelElementAndSet(
                    						grammarAccess.getExponentAccess().getExponentLeftAction_1_0(),
                    						current);
                    				

                    }

                    otherlv_2=(Token)match(input,35,FOLLOW_12); 

                    				newLeafNode(otherlv_2, grammarAccess.getExponentAccess().getCircumflexAccentKeyword_1_1());
                    			
                    // InternalSephirah.g:1333:4: ( (lv_right_3_0= ruleUnary ) )
                    // InternalSephirah.g:1334:5: (lv_right_3_0= ruleUnary )
                    {
                    // InternalSephirah.g:1334:5: (lv_right_3_0= ruleUnary )
                    // InternalSephirah.g:1335:6: lv_right_3_0= ruleUnary
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
    // InternalSephirah.g:1357:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalSephirah.g:1357:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalSephirah.g:1358:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalSephirah.g:1364:1: rulePrimaryExpression returns [EObject current=null] : ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= ruleDecimal ) ) ) | this_BooleanLiteral_5= ruleBooleanLiteral | this_MethodCall_6= ruleMethodCall | this_Constant_7= ruleConstant | this_Variable_8= ruleVariable ) ;
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
            // InternalSephirah.g:1370:2: ( ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= ruleDecimal ) ) ) | this_BooleanLiteral_5= ruleBooleanLiteral | this_MethodCall_6= ruleMethodCall | this_Constant_7= ruleConstant | this_Variable_8= ruleVariable ) )
            // InternalSephirah.g:1371:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= ruleDecimal ) ) ) | this_BooleanLiteral_5= ruleBooleanLiteral | this_MethodCall_6= ruleMethodCall | this_Constant_7= ruleConstant | this_Variable_8= ruleVariable )
            {
            // InternalSephirah.g:1371:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= ruleDecimal ) ) ) | this_BooleanLiteral_5= ruleBooleanLiteral | this_MethodCall_6= ruleMethodCall | this_Constant_7= ruleConstant | this_Variable_8= ruleVariable )
            int alt20=6;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // InternalSephirah.g:1372:3: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    {
                    // InternalSephirah.g:1372:3: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    // InternalSephirah.g:1373:4: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,18,FOLLOW_12); 

                    				newLeafNode(otherlv_0, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_0());
                    			

                    				newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_22);
                    this_Expression_1=ruleExpression();

                    state._fsp--;


                    				current = this_Expression_1;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_2=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_2());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSephirah.g:1391:3: ( () ( (lv_value_4_0= ruleDecimal ) ) )
                    {
                    // InternalSephirah.g:1391:3: ( () ( (lv_value_4_0= ruleDecimal ) ) )
                    // InternalSephirah.g:1392:4: () ( (lv_value_4_0= ruleDecimal ) )
                    {
                    // InternalSephirah.g:1392:4: ()
                    // InternalSephirah.g:1393:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrimaryExpressionAccess().getNumberLiteralAction_1_0(),
                    						current);
                    				

                    }

                    // InternalSephirah.g:1399:4: ( (lv_value_4_0= ruleDecimal ) )
                    // InternalSephirah.g:1400:5: (lv_value_4_0= ruleDecimal )
                    {
                    // InternalSephirah.g:1400:5: (lv_value_4_0= ruleDecimal )
                    // InternalSephirah.g:1401:6: lv_value_4_0= ruleDecimal
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
                    // InternalSephirah.g:1420:3: this_BooleanLiteral_5= ruleBooleanLiteral
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
                    // InternalSephirah.g:1429:3: this_MethodCall_6= ruleMethodCall
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
                    // InternalSephirah.g:1438:3: this_Constant_7= ruleConstant
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
                    // InternalSephirah.g:1447:3: this_Variable_8= ruleVariable
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
    // InternalSephirah.g:1459:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalSephirah.g:1459:55: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalSephirah.g:1460:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
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
    // InternalSephirah.g:1466:1: ruleBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_1= 'true' | lv_value_1_2= 'false' ) ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_1=null;
        Token lv_value_1_2=null;


        	enterRule();

        try {
            // InternalSephirah.g:1472:2: ( ( () ( ( (lv_value_1_1= 'true' | lv_value_1_2= 'false' ) ) ) ) )
            // InternalSephirah.g:1473:2: ( () ( ( (lv_value_1_1= 'true' | lv_value_1_2= 'false' ) ) ) )
            {
            // InternalSephirah.g:1473:2: ( () ( ( (lv_value_1_1= 'true' | lv_value_1_2= 'false' ) ) ) )
            // InternalSephirah.g:1474:3: () ( ( (lv_value_1_1= 'true' | lv_value_1_2= 'false' ) ) )
            {
            // InternalSephirah.g:1474:3: ()
            // InternalSephirah.g:1475:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
            					current);
            			

            }

            // InternalSephirah.g:1481:3: ( ( (lv_value_1_1= 'true' | lv_value_1_2= 'false' ) ) )
            // InternalSephirah.g:1482:4: ( (lv_value_1_1= 'true' | lv_value_1_2= 'false' ) )
            {
            // InternalSephirah.g:1482:4: ( (lv_value_1_1= 'true' | lv_value_1_2= 'false' ) )
            // InternalSephirah.g:1483:5: (lv_value_1_1= 'true' | lv_value_1_2= 'false' )
            {
            // InternalSephirah.g:1483:5: (lv_value_1_1= 'true' | lv_value_1_2= 'false' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==36) ) {
                alt21=1;
            }
            else if ( (LA21_0==37) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalSephirah.g:1484:6: lv_value_1_1= 'true'
                    {
                    lv_value_1_1=(Token)match(input,36,FOLLOW_2); 

                    						newLeafNode(lv_value_1_1, grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBooleanLiteralRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalSephirah.g:1495:6: lv_value_1_2= 'false'
                    {
                    lv_value_1_2=(Token)match(input,37,FOLLOW_2); 

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
    // InternalSephirah.g:1512:1: entryRuleMethodCall returns [EObject current=null] : iv_ruleMethodCall= ruleMethodCall EOF ;
    public final EObject entryRuleMethodCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodCall = null;


        try {
            // InternalSephirah.g:1512:51: (iv_ruleMethodCall= ruleMethodCall EOF )
            // InternalSephirah.g:1513:2: iv_ruleMethodCall= ruleMethodCall EOF
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
    // InternalSephirah.g:1519:1: ruleMethodCall returns [EObject current=null] : ( () ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) ;
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
            // InternalSephirah.g:1525:2: ( ( () ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) )
            // InternalSephirah.g:1526:2: ( () ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            {
            // InternalSephirah.g:1526:2: ( () ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            // InternalSephirah.g:1527:3: () ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')'
            {
            // InternalSephirah.g:1527:3: ()
            // InternalSephirah.g:1528:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMethodCallAccess().getMethodCallAction_0(),
            					current);
            			

            }

            // InternalSephirah.g:1534:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalSephirah.g:1535:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalSephirah.g:1535:4: (lv_name_1_0= ruleQualifiedName )
            // InternalSephirah.g:1536:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getMethodCallAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_8);
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

            otherlv_2=(Token)match(input,18,FOLLOW_23); 

            			newLeafNode(otherlv_2, grammarAccess.getMethodCallAccess().getLeftParenthesisKeyword_2());
            		
            // InternalSephirah.g:1557:3: ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=RULE_ID && LA23_0<=RULE_INT)||LA23_0==18||LA23_0==23||(LA23_0>=28 && LA23_0<=29)||LA23_0==32||(LA23_0>=36 && LA23_0<=42)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalSephirah.g:1558:4: ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    {
                    // InternalSephirah.g:1558:4: ( (lv_args_3_0= ruleExpression ) )
                    // InternalSephirah.g:1559:5: (lv_args_3_0= ruleExpression )
                    {
                    // InternalSephirah.g:1559:5: (lv_args_3_0= ruleExpression )
                    // InternalSephirah.g:1560:6: lv_args_3_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getMethodCallAccess().getArgsExpressionParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_10);
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

                    // InternalSephirah.g:1577:4: (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==19) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalSephirah.g:1578:5: otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,19,FOLLOW_12); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getMethodCallAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalSephirah.g:1582:5: ( (lv_args_5_0= ruleExpression ) )
                    	    // InternalSephirah.g:1583:6: (lv_args_5_0= ruleExpression )
                    	    {
                    	    // InternalSephirah.g:1583:6: (lv_args_5_0= ruleExpression )
                    	    // InternalSephirah.g:1584:7: lv_args_5_0= ruleExpression
                    	    {

                    	    							newCompositeNode(grammarAccess.getMethodCallAccess().getArgsExpressionParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_10);
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
                    	    break loop22;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,20,FOLLOW_2); 

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
    // InternalSephirah.g:1611:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalSephirah.g:1611:49: (iv_ruleConstant= ruleConstant EOF )
            // InternalSephirah.g:1612:2: iv_ruleConstant= ruleConstant EOF
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
    // InternalSephirah.g:1618:1: ruleConstant returns [EObject current=null] : ( () ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) ) ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_1=null;
        Token lv_value_1_2=null;
        Token lv_value_1_3=null;
        Token lv_value_1_4=null;
        Token lv_value_1_5=null;


        	enterRule();

        try {
            // InternalSephirah.g:1624:2: ( ( () ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) ) ) )
            // InternalSephirah.g:1625:2: ( () ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) ) )
            {
            // InternalSephirah.g:1625:2: ( () ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) ) )
            // InternalSephirah.g:1626:3: () ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) )
            {
            // InternalSephirah.g:1626:3: ()
            // InternalSephirah.g:1627:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getConstantAccess().getConstantAction_0(),
            					current);
            			

            }

            // InternalSephirah.g:1633:3: ( ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) ) )
            // InternalSephirah.g:1634:4: ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) )
            {
            // InternalSephirah.g:1634:4: ( (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' ) )
            // InternalSephirah.g:1635:5: (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' )
            {
            // InternalSephirah.g:1635:5: (lv_value_1_1= 'pi' | lv_value_1_2= 'G' | lv_value_1_3= 'phi' | lv_value_1_4= 'gamma' | lv_value_1_5= 'e' )
            int alt24=5;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt24=1;
                }
                break;
            case 39:
                {
                alt24=2;
                }
                break;
            case 40:
                {
                alt24=3;
                }
                break;
            case 41:
                {
                alt24=4;
                }
                break;
            case 42:
                {
                alt24=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalSephirah.g:1636:6: lv_value_1_1= 'pi'
                    {
                    lv_value_1_1=(Token)match(input,38,FOLLOW_2); 

                    						newLeafNode(lv_value_1_1, grammarAccess.getConstantAccess().getValuePiKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstantRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalSephirah.g:1647:6: lv_value_1_2= 'G'
                    {
                    lv_value_1_2=(Token)match(input,39,FOLLOW_2); 

                    						newLeafNode(lv_value_1_2, grammarAccess.getConstantAccess().getValueGKeyword_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstantRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalSephirah.g:1658:6: lv_value_1_3= 'phi'
                    {
                    lv_value_1_3=(Token)match(input,40,FOLLOW_2); 

                    						newLeafNode(lv_value_1_3, grammarAccess.getConstantAccess().getValuePhiKeyword_1_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstantRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_3, null);
                    					

                    }
                    break;
                case 4 :
                    // InternalSephirah.g:1669:6: lv_value_1_4= 'gamma'
                    {
                    lv_value_1_4=(Token)match(input,41,FOLLOW_2); 

                    						newLeafNode(lv_value_1_4, grammarAccess.getConstantAccess().getValueGammaKeyword_1_0_3());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstantRule());
                    						}
                    						setWithLastConsumed(current, "value", lv_value_1_4, null);
                    					

                    }
                    break;
                case 5 :
                    // InternalSephirah.g:1680:6: lv_value_1_5= 'e'
                    {
                    lv_value_1_5=(Token)match(input,42,FOLLOW_2); 

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
    // InternalSephirah.g:1697:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalSephirah.g:1697:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalSephirah.g:1698:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalSephirah.g:1704:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;



        	enterRule();

        try {
            // InternalSephirah.g:1710:2: ( (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* ) )
            // InternalSephirah.g:1711:2: (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* )
            {
            // InternalSephirah.g:1711:2: (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* )
            // InternalSephirah.g:1712:3: this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )*
            {

            			newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0());
            		
            pushFollow(FOLLOW_24);
            this_ValidID_0=ruleValidID();

            state._fsp--;


            			current.merge(this_ValidID_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalSephirah.g:1722:3: (kw= '.' this_ValidID_2= ruleValidID )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==43) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalSephirah.g:1723:4: kw= '.' this_ValidID_2= ruleValidID
            	    {
            	    kw=(Token)match(input,43,FOLLOW_5); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			

            	    				newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1());
            	    			
            	    pushFollow(FOLLOW_24);
            	    this_ValidID_2=ruleValidID();

            	    state._fsp--;


            	    				current.merge(this_ValidID_2);
            	    			

            	    				afterParserOrEnumRuleCall();
            	    			

            	    }
            	    break;

            	default :
            	    break loop25;
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
    // InternalSephirah.g:1743:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // InternalSephirah.g:1743:47: (iv_ruleValidID= ruleValidID EOF )
            // InternalSephirah.g:1744:2: iv_ruleValidID= ruleValidID EOF
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
    // InternalSephirah.g:1750:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_ESCAPED_ID_1=null;


        	enterRule();

        try {
            // InternalSephirah.g:1756:2: ( (this_ID_0= RULE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) )
            // InternalSephirah.g:1757:2: (this_ID_0= RULE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            {
            // InternalSephirah.g:1757:2: (this_ID_0= RULE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID) ) {
                alt26=1;
            }
            else if ( (LA26_0==RULE_ESCAPED_ID) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalSephirah.g:1758:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_0);
                    		

                    			newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSephirah.g:1766:3: this_ESCAPED_ID_1= RULE_ESCAPED_ID
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
    // InternalSephirah.g:1777:1: entryRuleDecimal returns [String current=null] : iv_ruleDecimal= ruleDecimal EOF ;
    public final String entryRuleDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimal = null;


        try {
            // InternalSephirah.g:1777:47: (iv_ruleDecimal= ruleDecimal EOF )
            // InternalSephirah.g:1778:2: iv_ruleDecimal= ruleDecimal EOF
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
    // InternalSephirah.g:1784:1: ruleDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalSephirah.g:1790:2: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? ) )
            // InternalSephirah.g:1791:2: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            {
            // InternalSephirah.g:1791:2: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )? )
            // InternalSephirah.g:1792:3: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )?
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_24); 

            			current.merge(this_INT_0);
            		

            			newLeafNode(this_INT_0, grammarAccess.getDecimalAccess().getINTTerminalRuleCall_0());
            		
            // InternalSephirah.g:1799:3: (kw= '.' this_INT_2= RULE_INT )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==43) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalSephirah.g:1800:4: kw= '.' this_INT_2= RULE_INT
                    {
                    kw=(Token)match(input,43,FOLLOW_25); 

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
    // InternalSephirah.g:1817:1: ruleComparisonOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<=' ) | (enumLiteral_1= '>=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '>' ) ) ;
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
            // InternalSephirah.g:1823:2: ( ( (enumLiteral_0= '<=' ) | (enumLiteral_1= '>=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '>' ) ) )
            // InternalSephirah.g:1824:2: ( (enumLiteral_0= '<=' ) | (enumLiteral_1= '>=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '>' ) )
            {
            // InternalSephirah.g:1824:2: ( (enumLiteral_0= '<=' ) | (enumLiteral_1= '>=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<' ) | (enumLiteral_5= '>' ) )
            int alt28=6;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt28=1;
                }
                break;
            case 45:
                {
                alt28=2;
                }
                break;
            case 46:
                {
                alt28=3;
                }
                break;
            case 47:
                {
                alt28=4;
                }
                break;
            case 48:
                {
                alt28=5;
                }
                break;
            case 49:
                {
                alt28=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalSephirah.g:1825:3: (enumLiteral_0= '<=' )
                    {
                    // InternalSephirah.g:1825:3: (enumLiteral_0= '<=' )
                    // InternalSephirah.g:1826:4: enumLiteral_0= '<='
                    {
                    enumLiteral_0=(Token)match(input,44,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorAccess().getLTEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getComparisonOperatorAccess().getLTEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalSephirah.g:1833:3: (enumLiteral_1= '>=' )
                    {
                    // InternalSephirah.g:1833:3: (enumLiteral_1= '>=' )
                    // InternalSephirah.g:1834:4: enumLiteral_1= '>='
                    {
                    enumLiteral_1=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorAccess().getGTEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getComparisonOperatorAccess().getGTEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalSephirah.g:1841:3: (enumLiteral_2= '==' )
                    {
                    // InternalSephirah.g:1841:3: (enumLiteral_2= '==' )
                    // InternalSephirah.g:1842:4: enumLiteral_2= '=='
                    {
                    enumLiteral_2=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorAccess().getEQEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getComparisonOperatorAccess().getEQEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalSephirah.g:1849:3: (enumLiteral_3= '!=' )
                    {
                    // InternalSephirah.g:1849:3: (enumLiteral_3= '!=' )
                    // InternalSephirah.g:1850:4: enumLiteral_3= '!='
                    {
                    enumLiteral_3=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorAccess().getNEQEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getComparisonOperatorAccess().getNEQEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalSephirah.g:1857:3: (enumLiteral_4= '<' )
                    {
                    // InternalSephirah.g:1857:3: (enumLiteral_4= '<' )
                    // InternalSephirah.g:1858:4: enumLiteral_4= '<'
                    {
                    enumLiteral_4=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getComparisonOperatorAccess().getLTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getComparisonOperatorAccess().getLTEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalSephirah.g:1865:3: (enumLiteral_5= '>' )
                    {
                    // InternalSephirah.g:1865:3: (enumLiteral_5= '>' )
                    // InternalSephirah.g:1866:4: enumLiteral_5= '>'
                    {
                    enumLiteral_5=(Token)match(input,49,FOLLOW_2); 

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


    protected DFA20 dfa20 = new DFA20(this);
    static final String dfa_1s = "\14\uffff";
    static final String dfa_2s = "\4\uffff\2\11\4\uffff\2\11";
    static final String dfa_3s = "\1\4\3\uffff\2\20\1\uffff\1\4\2\uffff\2\20";
    static final String dfa_4s = "\1\52\3\uffff\2\61\1\uffff\1\5\2\uffff\2\61";
    static final String dfa_5s = "\1\uffff\1\1\1\2\1\3\2\uffff\1\5\1\uffff\1\4\1\6\2\uffff";
    static final String dfa_6s = "\14\uffff}>";
    static final String[] dfa_7s = {
            "\1\4\1\5\1\2\13\uffff\1\1\21\uffff\2\3\5\6",
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

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1371:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= ruleDecimal ) ) ) | this_BooleanLiteral_5= ruleBooleanLiteral | this_MethodCall_6= ruleMethodCall | this_Constant_7= ruleConstant | this_Variable_8= ruleVariable )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000007F130C64072L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x000007F130C60072L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000100030L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x000007F130C60070L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0003F00000000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x000007F130D60070L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000040L});

}