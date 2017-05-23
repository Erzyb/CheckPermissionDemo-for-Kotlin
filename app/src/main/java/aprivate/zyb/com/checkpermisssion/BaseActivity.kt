package aprivate.zyb.com.checkpermisssion

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by zhouyibo on 2017/5/23.
 * kotlin
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        if (checkPermission() && CheckPermissionUtil.check(this)) {
            initActivity()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CheckPermissionUtil.PERMISSION_REQUEST_CODE) {
            if (CheckPermissionUtil.verifyPermissions(grantResults)) {
                CheckPermissionUtil.showMissingPermissionDialog(this)
            } else {
                initActivity()
            }
        }
    }

    open fun checkPermission(): Boolean {
        return false
    }

    abstract fun initActivity()
}
