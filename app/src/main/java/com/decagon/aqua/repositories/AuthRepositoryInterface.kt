package com.decagon.aqua.repositories

import com.decagon.aqua.models.Supplier
import com.decagon.aqua.models.supplierAuthModule.CompanyList
import com.decagon.aqua.models.supplierAuthModule.RegisterResponse
import retrofit2.Response

interface AuthRepositoryInterface {
    suspend fun addSupplier(supplier: Supplier): Response<RegisterResponse>
    suspend fun getCompanies(): Response<CompanyList>
//    suspend fun addConsumer(user: User): Response<RegisterResponse>
//    suspend fun loginUser(loginUserModel: LoginUserModel): Response<LoginUserResponseModel>
//    suspend fun updatePassword(updatePasswordModel: UpdatePasswordModel): Response<UpdatePasswordResponseModel>
//    suspend fun forgotPassword(EmailAddress: String): Response<ForgotPasswordResponseModel>
//    suspend fun resetPassword(resetPasswordModel: ResetPasswordModel): Response<ResetPasswordResponseModel>
//    suspend fun confirmEmail(confirmEmailModel: ConfirmEmailModel): Response<ConfirmEmailResponse>
//    suspend fun refreshToken(token: String, userId: String, refreshToken: String): Response<RefreshTokenResponseModel>
}
