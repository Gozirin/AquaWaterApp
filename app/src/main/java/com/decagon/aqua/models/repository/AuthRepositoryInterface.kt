package com.decagon.hbapplicationgroupa.repository.authmodulerepository

import com.decagon.hbapplicationgroupa.model.authmodule.resetpassword.ResetPasswordModel
import com.decagon.hbapplicationgroupa.model.authmodule.resetpassword.ResetPasswordResponseModel
import retrofit2.Response

interface AuthRepositoryInterface {
    suspend fun resetPassword(resetPasswordModel: ResetPasswordModel): Response<ResetPasswordResponseModel>
}
