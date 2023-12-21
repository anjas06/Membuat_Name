import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.anjaslp.ailoop.data.UserRepository
import com.anjaslp.ailoop.data.pref.UserModel

//import com.google.firebase.auth.FirebaseAuth

class HomeViewModel(val repository: UserRepository) : ViewModel() {
    fun getEmail(){
        repository.getSession()
    }

//    private val firebaseAuth = FirebaseAuth.getInstance()

//    fun getGreetingMessage(): String {
//        val firebaseUser = firebaseAuth.currentUser
//        return if (firebaseUser != null) {
//            "Hi, ${firebaseUser.displayName}"
//        } else {
//            ""
//        }
//    }

//    fun isUserLoggedIn(): Boolean {
////        return firebaseAuth.currentUser != null
//    }

//    fun getName():String{
//        return repository.getName().name.toString()
//    }

    fun getSession(): LiveData<UserModel> {
        return repository.getSession().asLiveData()
    }
}
