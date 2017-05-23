package aprivate.zyb.com.checkpermisssion

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog

object CheckPermissionUtil {
    val mNeedPermissions = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE)//填入需要检测的权限
    val PERMISSION_REQUEST_CODE = 0//权限获取值
    /**
     * 开始检查权限
     */
    fun check(activity: Activity): Boolean {
        val needRequestPermissionList = findDeniedPermissions(activity, mNeedPermissions)
        if (needRequestPermissionList.isNotEmpty()) {
            ActivityCompat.requestPermissions(activity, needRequestPermissionList.toTypedArray(), PERMISSION_REQUEST_CODE)
            return false
        }
        return true
    }

    /**
     * 筛选需要检查的权限
     */
    private fun findDeniedPermissions(activity: Activity, permissions: Array<String>): List<String> {
        return permissions.filter { ContextCompat.checkSelfPermission(activity, it) != PackageManager.PERMISSION_GRANTED || ActivityCompat.shouldShowRequestPermissionRationale(activity, it) }
    }

    /**
     * 判断是否获取所有需要的权限
     */
    fun verifyPermissions(grantResults: IntArray): Boolean {
        return grantResults.none { it != PackageManager.PERMISSION_GRANTED }
    }

    /**
     * 授权失败是友好提示
     */
    fun showMissingPermissionDialog(activity: Activity) {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("授权提示")
        builder.setMessage("取消授权将无法使用app")
        builder.setNegativeButton("取消") { _, _ -> activity.finish() }
        builder.setPositiveButton("设置") { _, _ -> startAppSettings(activity) }
        builder.setCancelable(false)
        builder.show()
    }

    /**
     * 跳转到应用手机权限管理
     */
    private fun startAppSettings(activity: Activity) {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        intent.data = Uri.parse("package:" + activity.packageName)
        activity.startActivity(intent)
    }
}
