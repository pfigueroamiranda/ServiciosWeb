package com.seit.silaba.presentation.ws;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedProperty;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seit.silaba.exceptions.ZMessManager;
import com.seit.silaba.modelo.Tbsilaber;
import com.seit.silaba.modelo.control.ITbsilaberLogic;
import com.seit.silaba.modelo.control.TbsilaberLogic;
import com.seit.silaba.presentation.businessDelegate.BusinessDelegatorView;
import com.seit.silaba.presentation.businessDelegate.IBusinessDelegatorView;
import com.seit.silaba.presentation.ws.model.SilaberModel;
import com.seit.silaba.utilities.FacesUtils;
import com.seit.silaba.utilities.SilabaAnswerWS;
import com.seit.silaba.utilities.SilabaError;
import com.seit.silaba.utilities.SilabaErrorCodes;
import com.seit.silaba.utilities.SilabaStatusResponse;

//@RestController
//@RequestMapping("/autentication")
@Path("/autentication")
public class AutenticationController2 {
	
	  @ManagedProperty(value = "#{BusinessDelegatorView}")
	    private IBusinessDelegatorView businessDelegatorView;
	  
		//@RequestMapping(value = "/login", produces = "application/json", method = RequestMethod.POST)
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
					ArrayList<Object> usermodelList = new ArrayList<>();
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
	/*EEJMPLO:
	 * {"consecutivo":"1","nombre":"Warner","apellido":"Fernando","fechaNacimiento":"30-12-1978","telefonoFijo":"55555","telefonoCelular":"3333","fechaCreacion":"02-01-2018","usuarioCreacion":"wanferv","usuario":"wanferv2","contrasena":"wanferv2"}
	*/
	  @POST
	  @Path("/createUser")
	  @Consumes({MediaType.APPLICATION_JSON})
	  @Produces({MediaType.APPLICATION_JSON})
		public SilabaAnswerWS  createUser(String cadena){
			SilabaAnswerWS answerWS = new SilabaAnswerWS<Tbsilaber>();
			ObjectMapper mapper = new ObjectMapper();
			Tbsilaber tbSilaber =null;
			try {
				//Se mapea la cadena Json a un objeto
				SilaberModel model= mapper.readValue(cadena,SilaberModel.class);
				
				boolean isCreado = createUser(model);
				if(isCreado){
					answerWS.setStatus(SilabaStatusResponse.SUCCESS.name());
				}else{
					answerWS.setStatus(SilabaStatusResponse.ERROR.name());
					answerWS.setError(setErrorCode(SilabaErrorCodes.FAIL_CREATING_SILABER.getCode(),
							SilabaErrorCodes.FAIL_CREATING_SILABER.getName(),  SilabaErrorCodes.FAIL_CREATING_SILABER.getName()));
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
		
	    public boolean createUser(SilaberModel model) {
	        try {
	        	Tbsilaber  entity = new Tbsilaber();

	            //Integer consecutivo = FacesUtils.checkInteger(txtConsecutivo);

	            entity.setApellido(model.getApellido());
	            entity.setConsecutivo(1);
	            //entity.setFechaCreacion(model.getFechaCreacion());
	            //entity.setFechaNacimiento(model.getFechaNacimiento());
	            entity.setNombre(model.getNombre());
	            entity.setTelefonoCelular(model.getTelefonoCelular());
	            entity.setTelefonoFijo(model.getTelefonoFijo());
	            entity.setUsuarioCreacion(model.getUsuarioCreacion());
	            entity.setUsuario(model.getUsuario());
	            entity.setContrasena(model.getContrasena());
	            businessDelegatorView.saveTbsilaber(entity);
	            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
	             return true;
	        } catch (Exception e) {
	        	 return false;
	        }
 
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
	    public IBusinessDelegatorView getBusinessDelegatorView() {
	        return businessDelegatorView;
	    }

	    public void setBusinessDelegatorView(
	        IBusinessDelegatorView businessDelegatorView) {
	        this.businessDelegatorView = businessDelegatorView;
	    }
		
}
