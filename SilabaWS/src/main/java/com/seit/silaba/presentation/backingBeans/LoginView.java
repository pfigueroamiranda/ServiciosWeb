package com.seit.silaba.presentation.backingBeans;

import com.seit.silaba.modelo.Tbsilaber;
import com.seit.silaba.modelo.control.ITbsilaberLogic;
import com.seit.silaba.modelo.control.TbsilaberLogic;
import com.seit.silaba.presentation.businessDelegate.BusinessDelegatorView;
import com.seit.silaba.presentation.businessDelegate.IBusinessDelegatorView;
import com.seit.silaba.presentation.ws.model.SilaberModel;
import com.seit.silaba.utilities.*;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@ViewScoped
@ManagedBean(name = "loginView")
@Path("/autentication")
public class LoginView {
    private String userId;
    private String password;
    @ManagedProperty(value = "#{authenticationManager}")
    private AuthenticationManager authenticationManager = null;
	  @ManagedProperty(value = "#{BusinessDelegatorView}")
	    private IBusinessDelegatorView businessDelegatorView;
	  

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(
        AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String login() {
        try {
        	FacesUtils.getSession().setAttribute("silaber",null); 
            
            Object[] variables = {"usuario", true, this.getUserId(), "=","contrasena", true, this.getPassword(), "="};
              
            List<Tbsilaber>  sil  = businessDelegatorView.findByCriteriaInTbsilaber(variables, null, null);
    		if(!sil.isEmpty()){
    			FacesUtils.getSession().setAttribute("silaber", sil.get(0));     
    			Authentication request = new UsernamePasswordAuthenticationToken(this.getUserId(),
    					this.getPassword());
    			Authentication result = authenticationManager.authenticate(request);
    			SecurityContext securityContext = SecurityContextHolder.getContext();
    			securityContext.setAuthentication(result);
    			
    			FacesUtils.getHttpSession(true)
    			.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
    		}else{
    			FacesUtils.addErrorMessage("Fallo usuario o contraseña");
    			return "/login.xhtml";
    		}
    		
        } catch (AuthenticationException e) {
            FacesUtils.addErrorMessage("Fallo usuario o contraseña");

            return "/login.xhtml";
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 FacesUtils.addErrorMessage("Fallo usuario o contraseña");
			 return "/login.xhtml";
		}

        return "/XHTML/initialMenu.xhtml";
    }
    public IBusinessDelegatorView getBusinessDelegatorView() {
        return businessDelegatorView;
    }

    public void setBusinessDelegatorView(
        IBusinessDelegatorView businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
    }
    
    /****************************/
	  @POST
	  @Path("/login")
	  @Consumes({MediaType.APPLICATION_JSON})
	  @Produces({MediaType.APPLICATION_JSON})
		public SilabaAnswerWS  autentication2(String login,  String password){
			SilabaAnswerWS answerWS = new SilabaAnswerWS<Tbsilaber>();
			Tbsilaber tbSilaber =null;
			try {
				tbSilaber = cosultarUsuario(login, password);
				if(tbSilaber !=null){
					List usermodelList = new ArrayList<>();
					usermodelList.add(SilaberModel.setupModel(tbSilaber));
					answerWS.setStatus(SilabaStatusResponse.SUCCESS.name());
					answerWS.setListResponse(usermodelList);
				}else{
					answerWS.setStatus(SilabaStatusResponse.ERROR.name());
					answerWS.setError(setErrorCode(SilabaErrorCodes.LOGIN_FAIL.getCode(),
							SilabaErrorCodes.LOGIN_FAIL.getName(),  SilabaErrorCodes.LOGIN_FAIL.getName()));
				}
				
			} catch (Exception e) {
				answerWS.setStatus(SilabaStatusResponse.ERROR.name());
				answerWS.setError(setErrorCode(SilabaErrorCodes.LOGIN_FAIL.getCode(),
						SilabaErrorCodes.LOGIN_FAIL.getName(), e.getMessage()));
				e.printStackTrace();
			}
			
			return answerWS;
			
		}

		private Tbsilaber cosultarUsuario(String usuario, String contrasena ){
			Tbsilaber tbsilaber =null;
			Object[] variables = {"usuario", true, usuario, "=","contrasena", true, contrasena, "="};
			ITbsilaberLogic iTbsilaberLogic = new TbsilaberLogic(); 
			//BusinessDelegatorView businessDelegatorView = new BusinessDelegatorView();
	        List<Tbsilaber> sil;
			try {
				sil = businessDelegatorView.findByCriteriaInTbsilaber(variables, null, null);
				if(!sil.isEmpty()){
					tbsilaber = sil.get(0);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return tbsilaber;
		}
		public SilabaError setErrorCode(String errorCode, String errorMessage) {
			return setErrorCode(errorCode, errorMessage, null);
		}

		public SilabaError setErrorCode(String errorCode, String errorMessage, String exceptionMessage) {
			SilabaError error = new SilabaError();
			error.setCode(errorCode);
			error.setMessage(errorMessage);
			if (exceptionMessage != null) {
				error.setDevMessage(exceptionMessage);
			}
			return error;
		}	
}
