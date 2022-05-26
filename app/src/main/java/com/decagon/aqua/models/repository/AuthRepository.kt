package com.decagon.hbapplicationgroupa.repository.authmodulerepository

import com.decagon.aqua.models.AuthAppModule
import com.decagon.hbapplicationgroupa.model.authmodule.resetpassword.ResetPasswordModel
import com.decagon.hbapplicationgroupa.model.authmodule.resetpassword.ResetPasswordResponseModel
import retrofit2.Response
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authModuleApiInterface: AuthAppModule
) : AuthRepositoryInterface {

    override suspend fun resetPassword(resetPasswordModel: ResetPasswordModel): Response<ResetPasswordResponseModel> {
        return authModuleApiInterface.resetPassword(resetPasswordModel)
    }
}
