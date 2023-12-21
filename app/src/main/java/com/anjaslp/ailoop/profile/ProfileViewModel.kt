import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.anjaslp.ailoop.data.UserRepository
import com.anjaslp.ailoop.data.pref.UserModel
import com.anjaslp.ailoop.data.pref.UserPreference
import kotlinx.coroutines.launch

//import com.google.firebase.auth.FirebaseAuth

class ProfileViewModel(private val repository: UserRepository) : ViewModel() {

//    private val firebaseAuth = FirebaseAuth.getInstance()
    val userFullName: MutableLiveData<String> = MutableLiveData()
    val userEmail: MutableLiveData<String> = MutableLiveData()
    val logoutResult: MutableLiveData<Boolean> = MutableLiveData()

    fun getUserInfo() {
////        val firebaseUser = firebaseAuth.currentUser
//        if (firebaseUser != null) {
//            userFullName.postValue(firebaseUser.displayName)
//            userEmail.postValue(firebaseUser.email)
//        }
    }

    fun getSession(): LiveData<UserModel> {
        return repository.getSession().asLiveData()
    }

    fun logout() {
        viewModelScope.launch {
            repository.logout()
            logoutResult.postValue(true)

        }
//        firebaseAuth.signOut()
//        logoutResult.postValue(true)
    }
}
