package com.androidstudy.mpesa.di

import com.androidstudy.daraja.Daraja
import com.androidstudy.daraja.util.Environment
import com.androidstudy.mpesa.Config
import com.androidstudy.mpesa.MpesaExpressApp
import com.androidstudy.mpesa.utils.AppUtils.passKey
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    private lateinit var app: MpesaExpressApp

    fun AppModule(application: MpesaExpressApp) {
        app = application
    }

    @Provides
    @Singleton
    fun providesApplication(): MpesaExpressApp {
        return app
    }

    @Provides
    @Singleton
    fun providesDaraja(): Daraja {
        return Daraja.builder(Config.CONSUMER_KEY, Config.CONSUMER_SECRET)
                .setBusinessShortCode(Config.BUSINESS_SHORTCODE)
                .setPassKey(passKey)
                .setTransactionType(Config.ACCOUNT_TYPE)
                .setCallbackUrl(Config.CALLBACK_URL)
                .setEnvironment(Environment.SANDBOX)
                .build()
    }

}