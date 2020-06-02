package com.leo.githubstars.ui.main

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.leo.githubstars.R
import com.leo.githubstars.enums.MainTabItems
import com.leo.githubstars.ui.base.BaseActivity
import com.leo.githubstars.ui.main.tab.BookmarkTabFragment
import com.leo.githubstars.ui.main.tab.GithubTabFragment
import com.leo.githubstars.util.LeoLog
import dagger.Lazy
import javax.inject.Inject

/**
 * Main화면의 Activity
 * Main 화면에 attached된 Fragment들을 생성한다.
 * @author LeoPark
 **/
class MainActivity : BaseActivity() {
    internal val tag = this.javaClass.simpleName

    /**
     * ActivitySubComponent(MainModule) 의존성 요청
     */
    @Inject
    lateinit var mainFragmentProvider: Lazy<MainFragment>

    @Inject
    lateinit var githubTabFragment: Lazy<GithubTabFragment>

    @Inject
    lateinit var bookmarkTabFragment: Lazy<BookmarkTabFragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, mainFragmentProvider.get())
                    .commitNow()
        }
    }

    fun getTabItemList(): HashMap<MainTabItems, Fragment> {
        val map = HashMap<MainTabItems, Fragment>()
        map[MainTabItems.GITHUB] = githubTabFragment.get()
        map[MainTabItems.BOOKMARK] = bookmarkTabFragment.get()

        return map
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        when(newConfig!!.orientation){
            Configuration.ORIENTATION_PORTRAIT -> {
                LeoLog.i(tag, "onConfigurationChanged ORIENTATION_PORTRAIT")
            }
            Configuration.ORIENTATION_LANDSCAPE -> {
                LeoLog.i(tag, "onConfigurationChanged ORIENTATION_PORTRAIT")
            }
        }
    }

    override fun onBackPressed() {
        backButtonClickSource.onNext(true)
    }

}
