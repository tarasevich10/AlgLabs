import unittest
import Include.Code.LabAlg2.Main


class TestAlg(unittest.TestCase):

    def test_alg(self):
        alg_list = [(1, 3), (7, 13), (2, 6), (12, 19)]

        result_list = [(1, 6), (7, 19)]

        self.assertEqual(Include.Code.LabAlg2.Main.alg(alg_list), result_list)
