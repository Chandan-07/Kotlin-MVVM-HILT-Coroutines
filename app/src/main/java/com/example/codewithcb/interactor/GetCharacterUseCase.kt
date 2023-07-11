package com.example.codewithcb.interactor



//class GetCharacterUseCase @Inject constructor(private val getCharacterRepository: GetCharacterRepository):
//    UseCase<GetCharacterUseCase.RequestValues, List<CharacterModel>>() {
//
//
//    data class RequestValues(
//        val input: String
//    ): InputValues
//
//
//    override suspend fun execute(input: RequestValues): Flow<List<CharacterModel>> {
//        return getCharacterRepository.getCharacters()
//    }
//
//    private fun getResponse(res: JobDetailResponse): UserJobDetailUI {
//        return UserJobDetailUI(
//            title = res.jobTitle,
//            salary = res.userSalary,
//            experience = res.userExperience,
//            company = res.userCompany
//        )
//    }
//
//}