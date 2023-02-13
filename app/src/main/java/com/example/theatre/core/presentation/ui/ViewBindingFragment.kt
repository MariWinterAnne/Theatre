package com.example.theatre.core.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * Базовый класс [ViewBindingFragment] для Фрагментов отвечаюший за binding и его инициализацию
 */
abstract class ViewBindingFragment<T : ViewBinding> : Fragment() {

    private var binding: T? = null

    /**
     * Функция для инициализации биндинга
     */
    abstract val initBinding: (inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean) -> T

    /**
     * Для единоразового доступа
     * Может выкинуть [IllegalStateException] если [binding] будет равен null
     */
    protected val nonNullBinding: T
        get() = binding ?: error("Unable to get access to binding")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = initBinding.invoke(inflater, container, false)
        return binding?.root
    }

    /**
     * Если нужно применить несколько действий к ViewBinding'у
     */
    protected fun withSafeBinding(block: T.() -> Unit) = binding?.let(block)

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}