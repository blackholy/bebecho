package kr.co.eoasis.bebecho.ui.main.post

import androidx.navigation.NavHostController
import kr.co.eoasis.bebecho.ui.main.post.PostNavigation.INQUIRY_SCREEN
import kr.co.eoasis.bebecho.ui.main.post.PostNavigation.NOTIFY_SCREEN
import kr.co.eoasis.bebecho.ui.main.post.PostNavigation.NOTIFY_SEE_MORE_ARGUMENT
import kr.co.eoasis.bebecho.ui.main.post.PostNavigation.NOTIFY_SEE_MORE_SCREEN
import kr.co.eoasis.bebecho.ui.main.post.PostNavigation.QUESTION_SCREEN
import kr.co.eoasis.bebecho.ui.navigation.BebechoDestinations

private object PostNavigation {
    const val NOTIFY_SCREEN = "notify"
    const val INQUIRY_SCREEN = "inquiry"
    const val QUESTION_SCREEN = "question"
    const val NOTIFY_SEE_MORE_SCREEN = "notifySeeMore"
    const val NOTIFY_SEE_MORE_ARGUMENT = "{id}"
}
object PostDestination {
    const val NOTIFY_ROUTE = NOTIFY_SCREEN
    const val INQUIRY_ROUTE = INQUIRY_SCREEN
    const val QUESTION_ROUTE = QUESTION_SCREEN
    const val NOTIFY_SEE_MORE_ROUTE = "${NOTIFY_SEE_MORE_SCREEN}/${NOTIFY_SEE_MORE_ARGUMENT}"

}
class PostNavigationActions(private val navController: NavHostController) {
    fun navigateToNotifySeeMore(id: String) {
        navController.navigate("${NOTIFY_SEE_MORE_SCREEN}/$id")
    }

    fun navigateToNotify() {
        navController.popBackStack()
        navController.navigate(PostDestination.NOTIFY_ROUTE)
    }

    fun navigateToInquiry() {
        navController.popBackStack()
        navController.navigate(PostDestination.INQUIRY_ROUTE)
    }
    fun navigateToQuestion() {
        navController.popBackStack()
        navController.navigate(PostDestination.QUESTION_ROUTE)
    }


}
