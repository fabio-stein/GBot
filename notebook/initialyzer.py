def init():
    import math
    from IPython import display
    from matplotlib import cm
    from matplotlib import gridspec
    from matplotlib import pyplot as plt
    import warnings
    import numpy as np
    import pandas as pd
    from sklearn import metrics
    with warnings.catch_warnings():
        warnings.filterwarnings("ignore", category=FutureWarning)
        import tensorflow as tf
    from tensorflow.python.data import Dataset
    import psycopg2

    plt.rcParams["figure.figsize"] = (20, 10)
    #tf.logging.set_verbosity(tf.logging.ERROR)
    pd.options.display.max_rows = 10
    pd.options.display.float_format = '{:.1f}'.format